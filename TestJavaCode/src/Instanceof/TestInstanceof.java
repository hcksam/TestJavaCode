package Instanceof;

import java.util.Date;

public class TestInstanceof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "testString";
		Date d1 = new Date();
		double n1 = 1234;
		Object o = n1;
		if (o instanceof Date){
			System.out.println("Double");
		}else if (o instanceof String){
			System.out.println("String");
		}else if (o instanceof Double){
			System.out.println("Double");
		}else{
			System.out.println("Others");
		}
	}

}
