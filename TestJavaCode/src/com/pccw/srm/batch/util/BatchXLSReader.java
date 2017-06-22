package com.pccw.srm.batch.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class BatchXLSReader{
	public ArrayList<ArrayList<Object>> readExcelData(File file) throws Exception{
		return readExcelData(file, 0, 0);
	}
	
	public ArrayList<ArrayList<Object>> readExcelData(File file, int skipRowNum) throws Exception{
		return readExcelData(file, 0, skipRowNum);
	}
	
	public ArrayList<ArrayList<Object>> readExcelData(File file, int SheetPage, int skipRowNum) throws Exception{
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		try{
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(SheetPage);
		    
		    if (sheet.getLastRowNum() > 0){
		    	int r = 0;
		    	for(Row row:sheet) {
		    		if (r<skipRowNum){
		    			r++;
		    			continue;
		    		}
			    	ArrayList<Object> dataRow = new ArrayList<Object>();
			    	for(int c=0; c<row.getLastCellNum(); c++) {
						Cell cell = row.getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK);
						if (cell != null){
							Object value;
							
							if (cell.getCellTypeEnum() == CellType.STRING) {
								value = cell.getStringCellValue();
							}else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
								value = cell.getNumericCellValue();
		                    }else if (HSSFDateUtil.isCellDateFormatted(cell)) {
		                    	value = cell.getDateCellValue();
		                    }else{
		                    	value = cell.getStringCellValue();
		                    }
							
							if (value != null && String.valueOf(value).trim().length() <= 0){
								value = null;
							}
							
							dataRow.add(value);
						}
					}
			    	data.add(dataRow);
			    	r++;
				}
		    }
		    
		    wb.close();
		    
	        return data;
		}catch (Exception e){
			throw e;
		}
	}
}
