package com.pccw.srm.batch.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.beanutils.PropertyUtils;

import com.pccw.srm.batch.dto.SPCBANewCSLRptDto;

public class BatchSPCBANewCSLRptLoader extends BatchDtoLoader{
	public final static SimpleDateFormat sdft_Mdyyyy = new SimpleDateFormat("M/d/yyyy H:m:s");
	public final static SimpleDateFormat sdft_MMddyyyy = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	public ArrayList<SPCBANewCSLRptDto> loadDto(ArrayList<ArrayList<Object>> data) throws Exception{
		ArrayList<SPCBANewCSLRptDto> dtoData = new ArrayList<SPCBANewCSLRptDto>();
		try{
			if (data == null || data.size() <= 0){
				return dtoData;
			}
			
			for (int r=0;r<data.size();r++){
				ArrayList<Object> row = data.get(r);
				SPCBANewCSLRptDto dto = new SPCBANewCSLRptDto();
				for (int c=0;c<dto.getColumnNames().length;c++){
					Object column = row.get(c);
					if (column != null){
						String columnName = dto.getColumnNames()[c];
						Object value = parseType(dto, columnName, column);
						
						if (columnName.equals("SALES_CREATE_DATE")){
							value = parseDate(column, sdft_Mdyyyy);
						}
						if (columnName.equals("SUBMITTED_DATE")){
							value = parseDate(column, sdft_Mdyyyy);
						}
						if (columnName.equals("MONTHLY_CHARGE")){
							value = parseDouble(parseString(column).substring(1));
						}
						if (columnName.equals("PROGRAM_START_DATE")){
							value = parseDate(column, sdft_MMddyyyy);
						}
//						if (columnName.equals("PROGRAM_END_DATE")){
//							value = parseDate(column, sdft_yyyyMMdd);
//						}
//						if (columnName.equals("PROGRAM_REMOVAL_DATE")){
//							value = parseDate(column, sdft_yyyyMMdd);
//						}
						if (columnName.equals("COMMENCEMENT_DATE")){
							value = parseDate(column, sdft_MMddyyyy);
						}
						if (columnName.equals("EXPIRY_DATE")){
							value = parseDate(column, sdft_MMddyyyy);
						}
						if (columnName.equals("CUT_OVER_DATE")){
							value = parseDate(column, sdft_Mdyyyy);
						}
						if (columnName.equals("SERVICE_EFFECTIVE_DATE")){
							value = parseDate(column, sdft_Mdyyyy);
						}
						if (columnName.equals("WPOS_SUBMITTED_DATE")){
							value = parseDate(column, sdft_Mdyyyy);
						}
						
						PropertyUtils.setSimpleProperty(dto, columnName, value);
					}
//					if (value == null){
//						System.out.println("("+r+","+c+") null");
//					}
				}
				dtoData.add(dto);
			}
			
			return dtoData;
		}catch (Exception e){
			throw e;
		}
	}
}
