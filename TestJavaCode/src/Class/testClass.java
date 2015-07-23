package Class;

public class testClass {
	public final static String s = getS();
	
	private static String getS(){
		String s = "abc";
		System.out.println(s);
		return s;
	}
	
	public static void main(String[] args){
		System.out.println("String value: "+testClass.s);
	}
}
