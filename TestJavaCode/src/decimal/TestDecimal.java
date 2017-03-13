package decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BigDecimal d = new BigDecimal("9.999999999999");
//		System.out.println(d);
		
		BigDecimal bd = new BigDecimal("0.1323");
		DecimalFormat df = new DecimalFormat("#.##");
		double calValue = Double.parseDouble(df.format(bd));
		calValue = calValue * 100;
	    System.out.println(calValue);
	}

}
