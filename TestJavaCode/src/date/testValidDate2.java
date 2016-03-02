package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testValidDate2 {
	public static void main(String[] args) {
		String inDate = "20010401";

		if (isValidDateMonth(inDate)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static boolean isValidDateMonth(String inDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		df.setLenient(false);
		try {
			Date d = df.parse(inDate);
			if (!inDate.equals(df.format(d))) {
				return false;
			} else {
				return true;
			}
		} catch (Exception pe) {
			return false;
		}
	}
}
