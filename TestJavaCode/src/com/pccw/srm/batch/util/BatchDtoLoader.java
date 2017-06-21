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
	
	public String parseString(Object object) throws Exception{
		return (object == null)? null:String.valueOf(object);
	}
	
	public Double parseDouble(Object object) throws Exception{
		String s = parseString(object);
		if (s == null || s.trim().equals("")){
			return null;
		}else{
			return Double.valueOf(s);
		}
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
		if (column != null){
			String columnType = PropertyUtils.getPropertyType(dto, columnName).getSimpleName();
			Object value = parseType(column, columnType, sdf);
			return value;
		}else{
			return null;
		}
	}
	
	public Object parseType(Object column, String columnType) throws Exception{
		return parseType(column, columnType, null);
	}
	
	public Object parseType(Object column, String columnType, SimpleDateFormat sdf) throws Exception{
		Object value = column;
		if (column != null){
			if (columnType.equalsIgnoreCase("Date") && !(column instanceof java.util.Date)){
				try{
					value = parseDate(column, sdf);
				}catch (Exception e){
				}
			}else if (columnType.equalsIgnoreCase("String") && !(column instanceof String)){
				try{
					value = parseString(column);
				}catch (Exception e){
				}
			}else if (columnType.equalsIgnoreCase("Double") && !(column instanceof Double)){
				try{
					value = parseDouble(parseString(column));
				}catch (Exception e){
				}
			}
			return value;
		}else{
			return null;
		}
	}
	
	public ArrayList<BatchLoaderDto> loadDto(ArrayList<ArrayList<Object>> data, Class dtoClass) throws Exception{
		return loadDto(data, dtoClass, INDEX_NORMAL);
	}
	
	public ArrayList<BatchLoaderDto> loadDto(ArrayList<ArrayList<Object>> data, Class dtoClass, int INDEX) throws Exception{
		ArrayList<BatchLoaderDto> dtoData = new ArrayList<BatchLoaderDto>();
		try{
			if (data == null || data.size() <= 0){
				return dtoData;
			}
			
			String[] columnNames = new String[]{};
			switch (INDEX){
				case INDEX_NORMAL:
					columnNames = ((BatchLoaderDto) dtoClass.newInstance()).getColumnNames();
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
				BatchLoaderDto dto = (BatchLoaderDto) dtoClass.newInstance();
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
	
	public ArrayList<BatchLoaderDto> loadDto(ArrayList<ArrayList<Object>> data, Class dtoClass, String[][] loadMap) throws Exception{
		ArrayList<BatchLoaderDto> dtoData = new ArrayList<BatchLoaderDto>();
		try{
			if (data == null || data.size() <= 0){
				return dtoData;
			}
			
			for (int r=0;r<data.size();r++){
				ArrayList<Object> row = data.get(r);
				BatchLoaderDto dto = (BatchLoaderDto) dtoClass.newInstance();
				
				int[] columnIndexs = new int[loadMap.length];
				String[] columnNames = dto.getColumnNames();
				for (int i=0;i<columnIndexs.length;i++){
					for (int j=0;j<columnNames.length;j++){
						String columnName = columnNames[j];
						if (columnName.equals(loadMap[i][0])){
							columnIndexs[i] = j;
							break;
						}
					}
				}
				
				for (int i=0;i<loadMap.length;i++){
					String[] lm = loadMap[i];
					String columnName = lm[0];
					String columnType = lm[1];
					SimpleDateFormat sdf = columnType.equalsIgnoreCase("Date")? new SimpleDateFormat(lm[2]):null;
					Object column = row.get(columnIndexs[i]);
					PropertyUtils.setSimpleProperty(dto, columnName, parseType(column, columnType, sdf));
				}
				
				dtoData.add(dto);
			}
			
			return dtoData;
		}catch (Exception e){
			throw e;
		}
	}
}
