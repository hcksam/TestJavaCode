package String;

public class TestSubString2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "n000010400004060";
		String bs1 = s.substring(0, 1);
		String bs2 = s.substring(0, 6);
		String es1 = s.substring(6,6+5);
		String es2 = s.substring(6+5);
		String ss1 = s.substring(6);
		System.out.println(bs1);
		System.out.println(bs2);
		System.out.println(es1);
		System.out.println(es2);
		System.out.println(ss1);
		
//		String s = "12345_11";
//		int index = s.lastIndexOf("_");
//		String ss1 = s.substring(0, index);
//		String ss2 = s.substring(index+1);
//		System.out.println(ss1);
//		System.out.println(ss2);
	}

}
