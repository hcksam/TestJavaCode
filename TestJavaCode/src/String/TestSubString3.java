package String;

public class TestSubString3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String k = "dd";
		String s = "ddabc hkt cdedd";
		int i = s.indexOf(k);
		String bs = s.substring(0,k.length());
		String es = s.substring(s.length()-k.length());
		String ks = s.substring(k.length(), s.length()-k.length());
		System.out.println(s);
		System.out.println(bs);
		System.out.println(ks);
	}

}
