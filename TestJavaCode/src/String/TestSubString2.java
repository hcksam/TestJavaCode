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
		System.out.println(bs1);
		System.out.println(bs2);
		System.out.println(es1);
		System.out.println(es2);
	}

}
