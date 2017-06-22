package Bean;

import java.io.File;
import java.util.ArrayList;

import com.pccw.srm.batch.dto.BatchLoaderDto;
import com.pccw.srm.batch.dto.SPCBANewCSLRptDto;
import com.pccw.srm.batch.util.BatchCSVWriter;
import com.pccw.srm.batch.util.BatchSPCBANewCSLRptLoader;
import com.pccw.srm.batch.util.BatchXLSReader;

public class TestLoadBean {

	public static void main(String[] args) throws Exception{
		File file = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport_20170427.xls");
		File outFile = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport.csv");
		File outFile2 = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport_2.csv");
		BatchXLSReader cr = new BatchXLSReader();
		ArrayList data = cr.readExcelData(file, 1);
		
//		SPCBANewCSLRptDto dto = new SPCBANewCSLRptDto();
//		BatchCSVWriter.writeCSV(outFile, data, dto.getColumnNames());
//		BatchSPCBANewCSLRptWriter.writeCSV(outFile, BatchSPCBANewCSLRptLoader.loadDto(data), dto.getColumnNames());
//		BatchCSVWriter cw = new BatchCSVWriter();
//		BatchSPCBANewCSLRptLoader lo = new BatchSPCBANewCSLRptLoader();
//		cw.writeCSV(outFile2, data, dto.getColumnNames());
//		cw.writeCSV(outFile, lo.loadDto(data), dto.getColumnNames());
		
//		BatchDtoLoader loader = new BatchDtoLoader();
//		String[][] loadMap = {
//				{"SHOP_ID","String"},
//				{"CHANNEL","String"},
//				{"BRAND","String"},
//				{"SALES_CREATE_DATE","Date","M/d/yyyy H:m:s"},
//				{"SUBMITTED_DATE","Date","M/d/yyyy H:m:s"},
////				{"MONTHLY_CHARGE","Double"},
//				{"PROGRAM_START_DATE","Date","MM/dd/yyyy HH:mm:ss"},
//				{"PROGRAM_END_DATE","Date","yyyy-MM-dd HH:mm:ss"},
//				{"IDD_ROAMING_SUBSCRIPTION","Double"},
//				{"VAS_CHARGE","Double"}
//		};
//		ArrayList<BatchLoaderDto> dtoData = loader.loadDto(data, SPCBANewCSLRptDto.class, loadMap);
		
		BatchSPCBANewCSLRptLoader loader = new BatchSPCBANewCSLRptLoader();
		BatchCSVWriter csv = new BatchCSVWriter();
//		ArrayList data = csv.readCSV(outFile, 1);
//		for (Object r:data){
//			ArrayList<String> row = (ArrayList<String>) r;
//			String line = "";
//			for (String column:row){
//				line += column+";";
//			}
//			System.out.println(line);
//		}
//		ArrayList<BatchLoaderDto> dtoData = loader.loadDto(data, SPCBANewCSLRptDto.class);
		ArrayList<SPCBANewCSLRptDto> dtoData = loader.loadDto(data);
//		for (BatchLoaderDto dto:dtoData){
//			System.out.println(dto);
//		}
		csv.writeCSV(outFile, dtoData, new SPCBANewCSLRptDto().getColumnNames());
//		csv.writeCSV(outFile2, dtoData, new SPCBANewCSLRptDto().getColumnNames());
		System.out.println("Done");
	}

}
