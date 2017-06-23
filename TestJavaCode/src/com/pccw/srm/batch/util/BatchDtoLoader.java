package com.pccw.srm.batch.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;

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
					if (column != null && String.valueOf(column).trim().length() > 0){
						String columnName = columnNames[c];
						Object value = BatchParseType.parseType(dto, columnName, column);
						try{
							PropertyUtils.setSimpleProperty(dto, columnName, value);
						}catch(IllegalArgumentException e){
							System.out.println("ERROR!");
							System.out.println("columnName: "+columnName);
							System.out.println("columnValue: "+value);
							throw e;
						}
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
		return loadDto(data, dtoClass, loadMap, null);
	}
	
	public ArrayList<BatchLoaderDto> loadDto(ArrayList<ArrayList<Object>> data, Class dtoClass, String[][] loadMap, Hashtable<String, BatchParseType> parseTypeMap) throws Exception{
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
					BatchParseType pt = (parseTypeMap != null)? parseTypeMap.get(columnName):null;
					Object value = column;
					boolean isRewrite = false;
					if (pt != null){
						isRewrite = pt.isRewrite();
						value = pt.parseType(column);
					}
					value = (isRewrite)? value:BatchParseType.parseType(value, columnType, sdf);
					try{
						PropertyUtils.setSimpleProperty(dto, columnName, value);
					}catch(IllegalArgumentException e){
						System.out.println("ERROR!");
						System.out.println("columnName: "+columnName);
						System.out.println("columnValue: "+value);
						throw e;
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
