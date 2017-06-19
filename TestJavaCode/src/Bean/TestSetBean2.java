package Bean;

import java.beans.PropertyDescriptor;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class TestSetBean2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TestBean2 tb = new TestBean2();
			
//			System.out.println("before: "+tb);
			
			String s1 = "testString";
			Date d1 = new Date();
			double n1 = 1234;
			
//			PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(tb);
//			for (PropertyDescriptor pd:pds){
//				if (pd.getName().equals("class")){
//					continue;
//				}
//				System.out.println(pd.getDisplayName());
//			}
//			
			String TypeName = PropertyUtils.getPropertyType(tb, "RUNDATE").getSimpleName();
			System.out.println(TypeName);
			
//			System.out.println("after: "+tb);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Fail");
		}
	}
}
