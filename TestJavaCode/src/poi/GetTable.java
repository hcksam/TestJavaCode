package poi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableRow;

public class GetTable {
	public void getTables() {
		BufferedInputStream bufIStream = null;
		FileInputStream fileIStream = null;
		File inputFile = null;
		HWPFDocument doc = null;
		Range range = null;
		ArrayList<Table> tables = null;
		Paragraph para = null;
		TableRow row = null;
		TableCell cell = null;
		boolean inTable = false;
		int numParas = 0;
		int numRowsInTable = 0;
		int numCellsInRow = 0;

		try {
			tables = new ArrayList<Table>();
			inputFile = new File("C:/temp/20120730e ContactCenterWorld.doc");
			fileIStream = new FileInputStream(inputFile);
			bufIStream = new BufferedInputStream(fileIStream);
			//
			// Open a Word document.
			//
			doc = new HWPFDocument(bufIStream);
			//
			// Get the highest level Range object that represents the
			// contents of the document.
			//
			range = doc.getRange();
			//
			// Get the number of paragraphs
			//
			numParas = range.numParagraphs();
			//
			// Step through each Paragraph.
			//
			for (int i = 0; i < numParas; i++) {
				para = range.getParagraph(i);
				//
				// Is the Paragraph within a table?
				//
				if (para.isInTable()) {
					//
					// The inTable flag is used to ensure that a call is made
					// to the getTable() method of the Range class once only
					// when the first Paragraph that is within a table is
					// recovered. So......
					//
					if (!inTable) {
						//
						// Get the table and add it to an ArrayList for later
						// processing. You do not have to do this, it would
						// be possible to process the table here. There are
						// methods defined on the Table class that allow you
						// to get at the number of rows in the table and to
						// recover a reference to each row in turn. Once you
						// have a row, it is possible then to get at each cell
						// in turn. Look at the Table, TableRow and TableCell
						// classes.
						//
						tables.add(range.getTable(para));
						inTable = true;
					}
				} else {
					//
					// Set the flag false to indicate that all of the paragrphs
					// in the table have been processed. A single blank line is
					// sufficient to indicate the end of the tbale within the
					// Word document.
					//
					// This is also the place that you could deal with any
					// non-table paragraphs.
					//
					inTable = false;
				}
			}
			//
			// This line simply prints out the number of tables found in the
			// document - used for testing purposes here.
			//
			System.out.println("Found " + tables.size()
					+ " tables in the document.");
			for (Table table : tables) {
				numRowsInTable = table.numRows();
				for (int i = 0; i < numRowsInTable; i++) {
					row = table.getRow(i);
					numCellsInRow = row.numCells();
					for (int j = 0; j < numCellsInRow; j++) {
						cell = row.getCell(j);
						System.out.println("Cell at row " + i + " column " + j
								+ " contains: " + cell.text());

					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Caught an: " + ex.getClass().getName());
			System.out.println("Message: " + ex.getMessage());
			System.out.println("Stacktrace follows:..............");
			ex.printStackTrace(System.out);
		} finally {
			if (bufIStream != null) {
				try {
					bufIStream.close();
					bufIStream = null;
					fileIStream = null;
				} catch (Exception ex) {
					// I G N O R E //
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GetTable().getTables();
	}

}
