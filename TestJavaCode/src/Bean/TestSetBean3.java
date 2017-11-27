package Bean;

import java.util.Date;
import java.util.LinkedList;

public class TestSetBean3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			LinkedList<TestBean2> l = new LinkedList<TestBean2>();
			TestBean2 tb = new TestBean2();
			
//			System.out.println("before: "+tb);
			
			String s1 = "testString";
			Date d1 = new Date();
			double n1 = 1234;
			
			l.add(tb);
			
			TestBean2 tb2 = l.get(0);
			
			tb2.setNAME("testString2");
			
			TestBean2 tb3 = l.get(0);
			
			String name = tb3.getNAME();
			System.out.println(name);
			
//			System.out.println("after: "+tb);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Fail");
		}
	}
}
