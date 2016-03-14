package Class;

public class testGetMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMethod());
	}
	
	public static String getMethod(){
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return methodName;
	}

}
