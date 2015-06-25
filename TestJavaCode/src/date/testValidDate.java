package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testValidDate {
	public static void main(String[] args){
		String inDate = "2/29/2015";
		String expectedPattern = "MM/dd/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		formatter.setLenient(false);
		try{
			formatter.parse(inDate);
			System.out.println("success");
		}catch (ParseException e){
			System.out.println("error");
		}
	}

}
