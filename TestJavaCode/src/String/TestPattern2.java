package String;

import java.util.regex.Pattern;

public class TestPattern2 {
	private static final String Sign_Sentence_Eng = "ba";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abc. bca?";
		Pattern pattern = Pattern.compile(Sign_Sentence_Eng);
		System.out.println(pattern.split(s)[0]);
	}

}
