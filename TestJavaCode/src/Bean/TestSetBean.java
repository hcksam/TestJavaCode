package Bean;

import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class TestSetBean {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TestBean2 tb = new TestBean2();
			
			System.out.println("before: "+tb);
			
			String s1 = "testString";
			Date d1 = new Date();
			double n1 = 1234;
			PropertyUtils.setSimpleProperty(tb, "NAME", s1);
			PropertyUtils.setSimpleProperty(tb, "RUNDATE", d1);
			PropertyUtils.setSimpleProperty(tb, "NUMBER", n1);
//			BeanUtils.setProperty(tb, "NAME", s1);
//			BeanUtils.setProperty(tb, "RUNDATE", d1);
//			BeanUtils.setProperty(tb, "NUMBER", n1);
			
			System.out.println("after: "+tb);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Fail");
		}
	}
}
