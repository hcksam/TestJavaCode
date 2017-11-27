package Bean;

import java.util.Date;

public class TestCompareBean {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			TestBean dtb = new TestBean("DTB", new Date(), 1);
			TestBean tb = new TestBean(dtb.getName(), dtb.getRunDate(), dtb.getNumber());
			
			System.out.println("default: "+dtb);
			
			System.out.println("before: "+tb);
			System.out.println("before compare: "+tb.equals(dtb));
			tb.setName("TB");
			System.out.println("after: "+tb);
			System.out.println("after compare: "+tb.equals(dtb));
			tb.setName("DTB");
			System.out.println("revert: "+tb);
			System.out.println("revert compare: "+tb.equals(dtb));
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Fail");
		}
	}
}
