package String;

import java.util.regex.Pattern;

public class TestSpilt2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a||b||0||";
		String[] ss = s.split(Pattern.quote("||"), -1);
		System.out.println(ss.length);
	}

}
