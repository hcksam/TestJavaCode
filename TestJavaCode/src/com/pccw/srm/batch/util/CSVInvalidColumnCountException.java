package com.pccw.srm.batch.util;

public class CSVInvalidColumnCountException extends Exception{
	private int rowID;
	private String row;
	private String columns;
	private int headColumnCount;
	private int columnCount;
	
	
	public CSVInvalidColumnCountException(int rowID, String row, String columns, int headColumnCount, int columnCount) {
		super();
		this.rowID = rowID;
		this.row = row;
		this.columns = columns;
		this.headColumnCount = headColumnCount;
		this.columnCount = columnCount;
	}


	@Override
	public String toString() {
		String message = super.toString();
		message += ": Invalid CSV Column Count!";
		message += "\n--Row ID: "+rowID;
		message += "\n--Row: "+row;
		message += "\n--Columns: "+columns;
		message += "\n--Head Column Count: "+headColumnCount;
		message += "\n--Column Count: "+columnCount;
		return message;
	}

}
