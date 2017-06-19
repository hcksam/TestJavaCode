package Bean;

import java.io.File;
import java.util.ArrayList;

import com.pccw.srm.batch.dto.SPCBANewCSLRptDto;
import com.pccw.srm.batch.util.BatchCSVWriter;
import com.pccw.srm.batch.util.BatchSPCBANewCSLRptLoader;
import com.pccw.srm.batch.util.BatchSPCBANewCSLRptWriter;
import com.pccw.srm.batch.util.BatchXLSReader;

public class TestLoadBean {

	public static void main(String[] args) throws Exception{
		File file = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport_20170427.xls");
		File outFile = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport.csv");
		File outFile2 = new File("C:/working/pccw-srm/workspace/test/ftp/SP_CBA_NewCSLReport_2.csv");
		BatchXLSReader cr = new BatchXLSReader();
		ArrayList data = cr.readExcelData(file, 1);
		
		SPCBANewCSLRptDto dto = new SPCBANewCSLRptDto();
//		BatchCSVWriter.writeCSV(outFile, data, dto.getColumnNames());
//		BatchSPCBANewCSLRptWriter.writeCSV(outFile, BatchSPCBANewCSLRptLoader.loadDto(data), dto.getColumnNames());
		BatchCSVWriter cw = new BatchCSVWriter();
		BatchSPCBANewCSLRptLoader lo = new BatchSPCBANewCSLRptLoader();
//		cw.writeCSV(outFile2, data, dto.getColumnNames());
		cw.writeCSV(outFile, lo.loadDto(data), dto.getColumnNames());
		System.out.println("Done");
	}

}
