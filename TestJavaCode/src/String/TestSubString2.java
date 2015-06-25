package String;

public class TestSubString2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "www.com";
		int index = s.indexOf(".");
		String bs = s.substring(0, index);
		String es = s.substring(index+1);
		System.out.println(bs);
		System.out.println(es);
	}

}
