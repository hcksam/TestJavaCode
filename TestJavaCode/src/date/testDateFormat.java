package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDateFormat {
	public static void main(String arg[]) throws ParseException{
		String date = "20170424";
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat osdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(date);
		System.out.println(osdf.format(now));
	}	

}
