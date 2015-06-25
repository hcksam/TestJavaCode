package String;

public class TestSpilt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a&//*b";
		String[] ss = s.split("[&/*]");
		for (int i=0;i<ss.length;i++){
			System.out.println(ss[i]);
		}
	}

}
