package String;

import java.lang.Character.UnicodeBlock;

public class TestChinese {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "中文eng!@#";
		System.out.println(s);
		System.out.println(UnicodeBlock.of(s.charAt(0)));
		System.out.println(UnicodeBlock.of(s.charAt(2)));
		System.out.println(UnicodeBlock.of(s.charAt(5)));
	}

}
