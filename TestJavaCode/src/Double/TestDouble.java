package Double;

public class TestDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Double d = Double.valueOf(String.valueOf(""));
//		Double d = null;
//		System.out.println(d);
		
		double d = Double.parseDouble("123456789.123456789");
		String result = String.valueOf(Math.round(d*100.0)/100.0);
		System.out.println(result);
	}

}
