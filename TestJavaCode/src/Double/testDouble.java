package Double;

import java.text.DecimalFormat;

public class testDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sd = "9999999999999.99";
		int index = sd.indexOf('.');
		double d = Double.parseDouble(sd);
		
		DecimalFormat df = new DecimalFormat("0");
		df.setMaximumFractionDigits(340);
		
		if (d > 9999999999999.99 || d < 0 || (index >= 0 && sd.substring(index+1).length() > 2)){
			System.out.println(d > 9999999999999.99);
			System.out.println(d < 0);
			System.out.println(index);
			System.out.println(sd.substring(index+1).length() > 2);
			System.out.println(df.format(d));
		}else{
			System.out.println("true");
			System.out.println(df.format(d));
		}
	}

}
