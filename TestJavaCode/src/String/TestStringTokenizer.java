package String;

import java.util.StringTokenizer;

public class TestStringTokenizer {

	public static void main(String[] args) {
		String oneLine = "";
		StringTokenizer st = new StringTokenizer(oneLine, ",");
		String[] testToken = new String[3];
		testToken[0] = st.nextToken().trim();
		testToken[1] = st.nextToken().trim();
	}
}
