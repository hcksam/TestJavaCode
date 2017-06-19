package com.pccw.srm.batch.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.pccw.srm.batch.JobDataMapKeys;
import com.pccw.srm.batch.dto.BatchLoaderDto;

public class BatchDtoLoader {
	public final static int INDEX_NORMAL = 0;
	public final static int INDEX_FRIST_ROW_AS_NAME = 1;
	public final static SimpleDateFormat sdft_yyyyMMdd = JobDataMapKeys.DATE_TIME_FORMAT;
	
//	public static ArrayList<String> getDtoColumnNames(Class dtoClass){
//		ArrayList<String> columnNames = new ArrayList<String>();
//		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(dtoClass);
//		for (PropertyDescriptor pd:pds){
//			if (pd.getName().equals("class")){
//				continue;
//			}
//			columnNames.add(pd.getName());
//		}
//		Collections.reverse(columnNames);
//		return columnNames;
//	}
	
	public ArrayList<Object> loadDto(ArrayList<ArrayList<Object>> data, BatchLoaderDto dto) throws Exception{
		return loadDto(data, dto, INDEX_NORMAL);
	}
	
	public String parseString(Object object) throws Exception{
		return (object == null)? null:String.valueOf(object);
	}
	
	public Date parseDate(Object object, SimpleDateFormat sdf) throws Exception{
		String s = parseString(object);
		if (s == null || s.trim().equals("")){
			return null;
		}else{
			return sdf.parse(s);
		}
	}
	
	public Object parseType(BatchLoaderDto dto, String columnName, Object column) throws Exception{
		return parseType(dto, columnName, column, sdft_yyyyMMdd);
	}
	
	public Object parseType(BatchLoaderDto dto, String columnName, Object column, SimpleDateFormat sdf) throws Exception{
		Object value = column;
		if (column != null){
			String columnType = PropertyUtils.getPropertyType(dto, columnName).getSimpleName();
			if (columnType.equals("Date") && !(column instanceof java.util.Date)){
				try{
					value = parseDate(column, sdf);
				}catch (Exception e){
				}
			}else if (columnType.equals("String") && !(column instanceof String)){
				try{
					value = parseString(column);
				}catch (Exception e){
				}
			}else if (columnType.equals("double") && !(column instanceof Double)){
				try{
					value = Double.parseDouble(parseString(column));
				}catch (Exception e){
				}
			}
			return value;
		}else{
			return null;
		}
	}
	
	public ArrayList<Object> loadDto(ArrayList<ArrayList<Object>> data, BatchLoaderDto dto, int INDEX) throws Exception{
		ArrayList<Object> dtoData = new ArrayList<Object>();
		try{
			if (data == null || data.size() <= 0){
				return dtoData;
			}
			
			String[] columnNames = new String[]{};
			switch (INDEX){
				case INDEX_NORMAL:
					columnNames = dto.getColumnNames();
					break;
				case INDEX_FRIST_ROW_AS_NAME:
					columnNames = new String[data.get(0).size()];
					for (int i=0;i<data.get(0).size();i++){
						String columnName = String.valueOf(data.get(0).get(i));
						columnNames[i] = columnName;
					}
					break;
			}
			
			for (int r=0;r<data.size();r++){
				ArrayList<Object> row = data.get(r);
				for (int c=0;c<dto.getColumnNames().length;c++){
					Object column = row.get(c);
					if (column != null){
						String columnName = columnNames[c];
						Object value = parseType(dto, columnName, column);
						PropertyUtils.setSimpleProperty(dto, columnName, value);
					}
				}
				dtoData.add(dto);
			}
			
			return dtoData;
		}catch (Exception e){
			throw e;
		}
	}
}
