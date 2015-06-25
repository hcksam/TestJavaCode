package excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

public class ReadInExcel {
	private File file;

	public ReadInExcel() {

	}

	public ReadInExcel(File file) {
		this.file = file;
	}

	public ArrayList<ArrayList<String>> getSheetData(int Page) {
		ArrayList<ArrayList<String>> outDatas = new ArrayList<ArrayList<String>>();
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				HSSFRow row = sheet.getRow(i); 
				ArrayList<String> rows = new ArrayList<String>();
				if (row != null) {
					for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
						rows.add(row.getCell(j).toString());
					}
					outDatas.add(rows);
				}else{
					System.out.println("null");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return (outDatas.size() > 0) ? removeNullColumn(outDatas) : outDatas;
	}

	private ArrayList<ArrayList<String>> removeNullColumn(
			ArrayList<ArrayList<String>> datas) {
		if (datas == null) {
			return null;
		}
		if (datas.size() == 0) {
			return datas;
		}
		for (int i = datas.get(0).size() - 1; i >= 0; i--) {
			boolean allNull = true;
			for (int j = 0; j < datas.size(); j++) {
				if (datas.get(j).get(i) != null) {
					allNull = false;
				}
			}
			if (allNull) {
				for (int j = 0; j < datas.size(); j++) {
					datas.get(j).remove(i);
				}
			}
		}
		return datas;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public static void main(String[] arg) {
		ReadInExcel rix = new ReadInExcel(new File(
				"C:/temp/20130601/Address 20130512.xls"));
		ArrayList<ArrayList<String>> excel = rix.getSheetData(0);
		for (int i = 0; i < excel.size(); i++) {
			ArrayList<String> row = excel.get(i);
			for (int j = 0; j < row.size(); j++) {
				String column = row.get(j);
				System.out.print(column + "|");
			}
			System.out.println();
		}
	}
}
