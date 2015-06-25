package String;

import java.util.ArrayList;

public class CapsString {
	public String CapString(String inString) {
		String[] IgnoreCase = { "NOW" };
		String[] IgnoreSign = { " " };
		String outString = "";

		int b = 0;
		ArrayList<String[]> splitResult = split(inString, IgnoreCase[b]);
		while (splitResult.size() == 0 && b+1 < IgnoreCase.length)
			splitResult = split(inString, IgnoreCase[++b]);
		for (int i=0;i<splitResult.size();i++){
			int c = b;
			String ts = splitResult.get(i)[0];
			while (++c < IgnoreCase.length) {
				ArrayList<String[]> tr = split(inString, IgnoreCase[c]);
				while (tr.size() == 0 && c+1 < IgnoreCase.length)
					tr = split(ts, IgnoreCase[++c]);
			}
		}

		// for (int j = 0; j < IgnoreCase.length; j++) {
		// if (inString.contains(IgnoreCase[j])) {
		// ArrayList<String[]> splitResult = split(inString, IgnoreCase[j]);
		// for (int i=0;i<splitResult.size();i++){
		// outString+=splitResult.get(i)[0].toUpperCase()+splitResult.get(i)[1];
		// }
		//
		// }
		// }
		return outString;
	}

	public ArrayList<String[]> split(String inString, String keyword) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		int index = inString.toUpperCase().indexOf(keyword.toUpperCase());
		String ts = inString;
		while (index >= 0) {
			String bs = ts.substring(0, index);
			String ks = ts.substring(index, index + keyword.length());
			String es = ts.substring(index + keyword.length());
			result.add(new String[] { bs, ks });
			ts = es;
			index = ts.toUpperCase().indexOf(keyword.toUpperCase());
			if (index < 0) {
				result.add(new String[] { ts, "" });
			}
		}
		return result;
	}

	public ArrayList<String[]> split(String inString, String[] keywords) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		int index = inString.toUpperCase().indexOf(keywords[0].toUpperCase());
		String ts = inString;
		int c = 0;
		while (index >= 0) {
			String bs = ts.substring(0, index);
			String ks = ts.substring(index, index + keywords[c].length());
			String es = ts.substring(index + keywords[c].length());
			result.add(new String[] { bs, ks });
			ts = es;
			while (index < 0)
				index = ts.toUpperCase().indexOf(keywords[++c].toUpperCase());
			if (index < 0) {
				result.add(new String[] { ts, "" });
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "now TV and now.com";
		CapsString cs = new CapsString();
		System.out.println(cs.CapString(s));
	}
}
