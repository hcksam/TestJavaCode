package com.pccw.srm.batch.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;

import com.pccw.srm.batch.JobDataMapKeys;
import com.pccw.srm.batch.dto.BatchLoaderDto;

public class BatchCSVWriter{
	SimpleDateFormat sdf = JobDataMapKeys.DATE_TIME_FORMAT;
	String delimiter = ",";
	String textDelimiter = "\"";
	
	public BatchCSVWriter(){
	}
	
	public BatchCSVWriter(String delimiter){
		init(delimiter, null, null);
	}
	
	public BatchCSVWriter(String delimiter, String textDelimiter){
		init(delimiter, textDelimiter, null);
	}
	
	public BatchCSVWriter(String delimiter, String textDelimiter, SimpleDateFormat sdf){
		init(delimiter, textDelimiter, sdf);
	}
	
	public BatchCSVWriter(SimpleDateFormat sdf){
		init(null, null, sdf);
	}
	
	public BatchCSVWriter(String delimiter, SimpleDateFormat sdf){
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
			setHeader(outData, header);
			
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
	
	void setHeader(ArrayList<String> outData, String[] header) throws Exception{
		if (header != null){
			String line = getLine(Arrays.asList(header));
    		outData.add(line);
		}
	}
	
	void setData(ArrayList<String> outData, Object rowObject) throws Exception{
		String line = "";
		if (rowObject instanceof BatchLoaderDto){
			BatchLoaderDto dto = (BatchLoaderDto) rowObject;
			line = getLine(dto);
		}else{
			List row = (List) rowObject;
			line = getLine(row);
		}
		
		line = line.substring(0, line.length()-delimiter.length());
		outData.add(line);
	}
	
	String getLine(List row) throws Exception{
		String line = "";
		for (Object column:row){
			String value = getOutValue(column);
			line += value;
			line += delimiter;
		}
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
		return line;
	}
	
	String getOutTextValue(Object inValue){
		String value = "";
		if (inValue != null){
			value = String.valueOf(inValue);
			value = value.replaceAll(textDelimiter, textDelimiter+textDelimiter);
			value = textDelimiter+value+textDelimiter;
		}
		return value;
	}
	
	String getOutValue(Object inValue){
		String value = "";
		if (inValue != null){
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
}
