package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class testCompareDate {
	public final static SimpleDateFormat DefaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		String d1 = DefaultDateFormat.format(new Date());
		String d2 = "2016-11-13";
		try{
		System.out.println(DefaultDateFormat.parse(d1).getTime());
		System.out.println(DefaultDateFormat.parse(d2).getTime());
		System.out.println(DefaultDateFormat.parse(d1).getTime()-DefaultDateFormat.parse(d2).getTime());
		System.out.println ("Days: " + TimeUnit.DAYS.convert(DefaultDateFormat.parse(d1).getTime()-DefaultDateFormat.parse(d2).getTime(), TimeUnit.MILLISECONDS));
		}catch(Exception e){
			
		}
	}

}
