package com.pccw.srm.batch.util;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;

import com.pccw.srm.batch.dto.SPCBANewCSLRptDto;

public class BatchSPCBANewCSLRptWriter{
	public static void writeCSV(File file, ArrayList<Object> data) throws Exception{
		writeCSV(file, data, null, ",", "\"");
	}
	
	public static void writeCSV(File file, ArrayList<Object> data, String[] header) throws Exception{
		writeCSV(file, data, header, ",", "\"");
	}
	
	public static void writeCSV(File file, ArrayList<Object> data, String[] header, String delimiter) throws Exception{
		writeCSV(file, data, header, delimiter, "\"");
	}
	
	public static void writeCSV(File file, ArrayList<Object> data, String delimiter) throws Exception{
		writeCSV(file, data, null, delimiter, "\"");
	}
	
	public static void setData(ArrayList<String> outData, ArrayList<Object> dtoData, String delimiter, String textDelimiter) throws Exception{
		for (int i=0;i<dtoData.size();i++){
			SPCBANewCSLRptDto dto = (SPCBANewCSLRptDto) dtoData.get(i);
			String[] columnNames = dto.getColumnNames();
    		String line = "";
    		for (String columnName:columnNames){
    			Object value = PropertyUtils.getSimpleProperty(dto, columnName);
    			if (value != null){
	    			if (value instanceof String){
	    				value = String.valueOf(value).replaceAll(textDelimiter, textDelimiter+textDelimiter);
	    				value = textDelimiter+value+textDelimiter;
	    			}else{
	    				try{
	    					Double.parseDouble(String.valueOf(value));
	    				}catch (Exception e){
	    					value = String.valueOf(value).replaceAll(textDelimiter, textDelimiter+textDelimiter);
	    					value = textDelimiter+value+textDelimiter;
	    				}
	    			}
    			}else{
    				value = "";
    			}
    			line += value;
    			line += delimiter;
    		}
    		line = line.substring(0, line.length()-delimiter.length());
    		outData.add(line);
    	}
	}
	
	public static void writeCSV(File file, ArrayList<Object> dtoData, String[] header, String delimiter, String textDelimiter) throws Exception{
		try{
			ArrayList<String> outData = new ArrayList<String>();
			if (header != null){
				String line = "";
	    		for (Object headValue:header){
	    			headValue = String.valueOf(headValue).replaceAll(textDelimiter, textDelimiter+textDelimiter);
	    			line += textDelimiter+headValue+textDelimiter;
	    			line += delimiter;
	    		}
	    		line = line.substring(0, line.length()-1);
	    		outData.add(line);
			}
			
			setData(outData, dtoData, delimiter, textDelimiter);
			
			FileUtils.writeLines(file, outData);
		}catch (Exception e){
			throw e;
		}
	}
}
