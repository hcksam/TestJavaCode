package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testSPDateFormat {
	public static void main(String arg[]) throws ParseException{
		String date = "4/27/2017 11:34:5";
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy H:m:s");
		SimpleDateFormat osdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(date);
		System.out.println(osdf.format(d));
	}	

}
