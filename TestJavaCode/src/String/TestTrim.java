package String;

public class TestTrim {
	public static void main(String[] args) {
		String s = " "+Character.toString ((char) 160)+" "+Character.toString ((char) 160)+" ";
		System.out.println(trim(s).length());
	}
	
	public static String trim(String inString){
		if (inString == null){
			return null;
		}
		String s = inString.replace((char) 160, ' ').trim();
//		while (s.indexOf((char) 160) >= 0){
//			s = s.replace((char) 160, ' ').trim();
//		}
		return s;
	}

	public static boolean isEmpty(String inString){
		if (inString == null){
			return true;
		}
		String s = inString.replaceAll(String.valueOf((char) 160), " ").trim();
		return (s.equals("NaN") || s.equals(""));
	}
}
