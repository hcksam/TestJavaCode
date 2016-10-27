package String;

import java.util.regex.Pattern;

public class TestSpilt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a||b||0";
		String[] ss = s.split(Pattern.quote("||"));
		for (int i=0;i<ss.length;i++){
			System.out.println(ss[i]);
		}
	}

}
