package calculate;

import java.text.DecimalFormat;

public class TestCalculate {
	public final static DecimalFormat DefaultDecimalFormat = new DecimalFormat("0.00");
	public final static DecimalFormat IntegerFormat = new DecimalFormat("0");
	
	public final static long KB = 1024;
    public final static long MB = KB*1024;
    public final static long GB = MB*1024;
    public final static long TB = GB*1024;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = 5*TB;
		double c = (double) a/TB;
		System.out.println(IntegerFormat.format(c));
	}

}
