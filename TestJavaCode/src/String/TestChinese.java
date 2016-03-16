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
		System.out.println(isWritten(s.charAt(0)));
		System.out.println(isWritten(s.charAt(2)));
		System.out.println(isWritten(s.charAt(5)));
	}
	
	public static boolean isWritten(Character inChar){
        boolean isWritten = false;
        int codePoint = inChar.hashCode();

        if (Character.UnicodeBlock.of(codePoint) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || Character.isAlphabetic(codePoint)) {
        	isWritten = true;
        }
        return isWritten;
    }
}
