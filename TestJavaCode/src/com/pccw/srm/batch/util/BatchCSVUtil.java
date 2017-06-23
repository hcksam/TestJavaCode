package com.pccw.srm.batch.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;
import org.mozilla.universalchardet.UniversalDetector;

import com.pccw.srm.batch.JobDataMapKeys;
import com.pccw.srm.batch.dto.BatchLoaderDto;

public class BatchCSVUtil{	
	SimpleDateFormat sdf = JobDataMapKeys.DATE_TIME_FORMAT;
	String delimiter = ",";
	String textDelimiter = "\"";
	
	public BatchCSVUtil(){
	}
	
	public BatchCSVUtil(String delimiter){
		init(delimiter, null, null);
	}
	
	public BatchCSVUtil(String delimiter, String textDelimiter){
		init(delimiter, textDelimiter, null);
	}
	
	public BatchCSVUtil(String delimiter, String textDelimiter, SimpleDateFormat sdf){
		init(delimiter, textDelimiter, sdf);
	}
	
	public BatchCSVUtil(SimpleDateFormat sdf){
		init(null, null, sdf);
	}
	
	public BatchCSVUtil(String delimiter, SimpleDateFormat sdf){
		init(delimiter, null, sdf);
	}
	
	public void init(String delimiter, String textDelimiter, SimpleDateFormat sdf){
		if (delimiter != null){
			delimiter = this.delimiter;
		}
		if (textDelimiter != null){
			textDelimiter = this.textDelimiter;
		}
		if (sdf != null){
			sdf = this.sdf;
		}
	}
	
	public void writeCSV(File file, List allData) throws Exception{
		writeCSV(file, allData, null);
	}
	
//	public void writeCSV(File file, ArrayList<ArrayList<Object>> data) throws Exception{
//		writeCSV(file, data, null, delimiter, textDelimiter);
//	}
//	
//	public void writeCSV(File file, ArrayList<ArrayList<Object>> data, String[] header) throws Exception{
//		writeCSV(file, data, header, delimiter, textDelimiter);
//	}
//	
//	public void writeCSV(File file, ArrayList<ArrayList<Object>> data, String[] header, String delimiter) throws Exception{
//		writeCSV(file, data, header, delimiter, textDelimiter);
//	}
//	
//	public void writeCSV(File file, ArrayList<ArrayList<Object>> data, String delimiter) throws Exception{
//		writeCSV(file, data, null, delimiter, textDelimiter);
//	}
//	
//	public void writeCSV(File file, ArrayList<ArrayList<Object>> data, String[] header, String delimiter, String textDelimiter) throws Exception{
	public void writeCSV(File file, List allData, String[] header) throws Exception{
		try{
			ArrayList<String> outData = new ArrayList<String>();
			
			if (header != null){
				String line = getLine(Arrays.asList(header));
	    		outData.add(line);
			}
			
			for (int i=0;i<allData.size();i++){
				setData(outData, allData.get(i));
			}
			
			FileUtils.writeLines(file, outData);
		}catch (Exception e){
			throw e;
		}
	}
	
//	public void writeCSV(File file, ArrayList<BatchLoaderDto> allData, String[] header) throws Exception{
//		try{
//			ArrayList<String> outData = new ArrayList<String>();
//			setHeader(outData, header);
//			
//			for (int i=0;i<allData.size();i++){
//				setData(outData, allData.get(i));
//			}
//			
//			FileUtils.writeLines(file, outData);
//		}catch (Exception e){
//			throw e;
//		}
//	}
	
	public ArrayList<ArrayList<String>> readCSV(File file, int skipNum) throws Exception{
		return readCSV(file, skipNum, false);
	}
	
	public ArrayList<ArrayList<String>> readCSV(File file, int skipNum, boolean keepTextDelimiter) throws Exception{
		try{
			String encoding = getEncoding(file);
			List<String> data = FileUtils.readLines(file, encoding);
			ArrayList<ArrayList<String>> outData = new ArrayList<ArrayList<String>>();
			
			int columnNum = 0;
			for (int r=0;r<data.size();r++){
				String row = data.get(r);
				if (r == 0){
					columnNum = countDelimiter(row, delimiter)+1;
				}
				if (r<skipNum){
					continue;
				}
				String[] cols = row.split(Pattern.quote(delimiter), -1);
				ArrayList<String> columns = new ArrayList<String>();
				boolean isText = false;
				String text = "";
				for (String col:cols){
					int tdc = countDelimiter(col, textDelimiter);
					if (tdc == 0 || tdc%2 == 0){
						if (isText){
							text += getTextValue(col, keepTextDelimiter)+delimiter;
						}else{
							columns.add(getTextValue(col, keepTextDelimiter));
						}
					}else{
						text += getTextValue(col, keepTextDelimiter);
						if (isText){
							columns.add(getTextValue(text, keepTextDelimiter));
							isText = false;
							text = "";
						}else{
							isText = true;
							text += delimiter;
						}
					}
				}
				if (columns.size() != columnNum){
					System.out.println(row);
					for (int i=0;i<columns.size();i++){
						System.out.println(i+": "+columns.get(i));
					}
					throw new CSVInvalidColumnCountException(r, row, columns.toString(), columnNum, columns.size());
				}
				outData.add(columns);
			}
			return outData;
		}catch (Exception e){
			throw e;
		}
	}
	
	public ArrayList<ArrayList<Object>> readCSVAsObject(File file, int skipNum) throws Exception{
		try{
			ArrayList<ArrayList<String>> data = readCSV(file, skipNum, true);
			ArrayList<ArrayList<Object>> outData = new ArrayList<ArrayList<Object>>();
			
			for (ArrayList<String> row:data){
				ArrayList<Object> outRow = new ArrayList<Object>();
				for (String column:row){
					Object value = null;
					if (column != null && String.valueOf(column).trim().length() > 0){
						if (inTextDelimiter(column, textDelimiter)){
							value = getTextValue(column, false);
						}
						if (value == null){
							try{
								value = sdf.parse(column);
							}catch (Exception e){
							}
						}
						if (value == null){
							try{
								value = Double.valueOf(column);
							}catch (Exception e){
							}
						}
					}
					outRow.add(value);
				}
				outData.add(outRow);
			}
			
			return outData;
		}catch (Exception e){
			throw e;
		}
	}
	
	void setData(ArrayList<String> outData, Object rowObject) throws Exception{
		String line = "";
		if (rowObject instanceof BatchLoaderDto){
			BatchLoaderDto dto = (BatchLoaderDto) rowObject;
			line = getLine(dto);
		}else{
			List<String> row = (List<String>) rowObject;
			line = getLine(row);
		}
		outData.add(line);
	}
	
	String getLine(List<String> row) throws Exception{
		String line = "";
		for (Object column:row){
			String value = getOutValue(column);
			line += value;
			line += delimiter;
		}
		line = line.substring(0, line.length()-delimiter.length());
		return line;
	}
	
	String getLine(BatchLoaderDto dto) throws Exception{
		String line = "";
		String[] columnNames = dto.getColumnNames();
		for (String columnName:columnNames){
			Object column = PropertyUtils.getSimpleProperty(dto, columnName);
			String value = getOutValue(column);
			line += value;
			line += delimiter;
		}
		line = line.substring(0, line.length()-delimiter.length());
		return line;
	}
	
	String getOutTextValue(Object inValue){
		String value = "";
		if (inValue != null && String.valueOf(inValue).trim().length() > 0){
			value = String.valueOf(inValue);
			value = value.replaceAll(Pattern.quote(textDelimiter), textDelimiter+textDelimiter);
			value = textDelimiter+value+textDelimiter;
		}
		return value;
	}
	
	String getTextValue(String inValue, boolean keepTextDelimiter){
		String value = inValue;
		if (inValue != null && String.valueOf(inValue).trim().length() > 0){
			String rd = textDelimiter+textDelimiter;
			if (!keepTextDelimiter && !inTextDelimiter(inValue, rd) && inTextDelimiter(inValue, textDelimiter)){
				value = inValue.substring(textDelimiter.length(), inValue.length()-textDelimiter.length());
			}
			value = value.replaceAll(Pattern.quote(rd), textDelimiter);
		}
		return value;
	}
	
	String getOutValue(Object inValue){
		String value = "";
		if (inValue != null && String.valueOf(inValue).trim().length() > 0){
			if (inValue instanceof String){
				value = getOutTextValue(inValue);
			}else if (inValue instanceof java.util.Date){
				value = sdf.format(inValue);
			}else{
				try{
					Double.parseDouble(String.valueOf(inValue));
					value = inValue.toString();
				}catch (Exception e){
					value = getOutTextValue(inValue);
				}
			}
		}
		return value;
	}
	
	public static boolean inTextDelimiter(String inValue, String textDelimiter){
		if (inValue == null || inValue.length()<textDelimiter.length()*2){
			return false;
		}
		if (inValue.substring(0,textDelimiter.length()).equals(textDelimiter) && inValue.substring(inValue.length()-textDelimiter.length()).equals(textDelimiter)){
			return true;
		}else{
			return false;
		}
	}
	
	public static int countDelimiter(String inValue, String delimiter){
		return inValue.length() - inValue.replaceAll(Pattern.quote(delimiter), "").length();
	}
	
	public static String getEncoding(File file){
        try{
            byte[] buf = new byte[4096];
            FileInputStream fis = new FileInputStream(file);
            UniversalDetector detector = new UniversalDetector(null);
            int nread;
            while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, nread);
            }
            detector.dataEnd();
            String encoding = detector.getDetectedCharset();
            detector.reset();
            fis.close();
            
            if (encoding == null){
                encoding = "UTF-8";
            }
            return encoding;
        }catch (Exception e){
            return null;
        }
    }
}
