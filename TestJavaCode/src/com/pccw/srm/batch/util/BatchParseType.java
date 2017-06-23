package com.pccw.srm.batch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.pccw.srm.batch.JobDataMapKeys;
import com.pccw.srm.batch.dto.BatchLoaderDto;

public abstract class BatchParseType {
	public static String parseString(Object object) throws Exception{
		return (object == null)? null:String.valueOf(object);
	}
	
	public static Double parseDouble(Object object) throws Exception{
		String s = parseString(object);
		if (s == null || s.trim().equals("")){
			return null;
		}else{
			return Double.valueOf(s);
		}
	}
	
	
	public static Date parseDate(Object object, SimpleDateFormat sdf) throws Exception{
		String s = parseString(object);
		if (s == null || s.trim().equals("")){
			return null;
		}else{
			return sdf.parse(s);
		}
	}
	
	public static Object parseType(BatchLoaderDto dto, String columnName, Object column) throws Exception{
		return parseType(dto, columnName, column, JobDataMapKeys.DATE_TIME_FORMAT);
	}
	
	public static Object parseType(BatchLoaderDto dto, String columnName, Object column, SimpleDateFormat sdf) throws Exception{
		if (column != null && String.valueOf(column).trim().length() > 0){
			String columnType = PropertyUtils.getPropertyType(dto, columnName).getSimpleName();
			Object value = parseType(column, columnType, sdf);
			return value;
		}else{
			return null;
		}
	}
	
	public static Object parseType(Object column, String columnType) throws Exception{
		return parseType(column, columnType, null);
	}
	
	public static Object parseType(Object column, String columnType, SimpleDateFormat sdf) throws Exception{
		Object value = column;
		if (column != null && String.valueOf(column).trim().length() > 0){
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
	
	public abstract Object parseType(Object inValue) throws Exception;
	
	public boolean isRewrite() {
		return true;
	}
}
