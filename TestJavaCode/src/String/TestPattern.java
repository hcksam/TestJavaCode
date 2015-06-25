package String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Matcher m = Pattern.compile("[A-Za-z0-9 ]").matcher("i*{}()+\'[]|$^?#;. am good");
		String s = "";
		while(m.find()) s += m.group();
		System.out.println(s);
	}

}
