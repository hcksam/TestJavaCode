package excel;



import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class TestReadExcel {
	public void readExcel() throws Exception{
		File file = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport_20170427.xls");
		File outFile = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport.csv");
		LinkedList<String> outData = new LinkedList<String>();
		
		try{
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    
		    for(Row row : sheet) {
		    	String line = "";
		    	for(int c=0; c<row.getLastCellNum(); c++) {
					Cell cell = row.getCell(c, Row.CREATE_NULL_AS_BLANK);
					if (cell != null){
	        			if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
		                	line += "\""+cell.getStringCellValue()+"\"";
	                    }else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
	                    	line += cell.getNumericCellValue();
	                    }else if (HSSFDateUtil.isCellDateFormatted(cell)) {
	                    	line += cell.getDateCellValue();
	                    }else{
	                    	line += cell.getStringCellValue();
	                    }
					}
                	line+=",";
				}
				line = line.substring(0, line.length()-1);
	            outData.add(line);
	            System.out.println(line);
			}
	        
	        FileUtils.writeLines(outFile, outData);
		}catch (Exception e){
			throw e;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TestReadExcel tre = new TestReadExcel();
			tre.readExcel();
			System.out.println("Success");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
