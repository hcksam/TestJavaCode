package Static;

public class TestStaticData {
	public static void f1(){
		System.out.println(StaticData.s2);
		StaticData.setS2("tt");
	}
	
	public static void f2(){
		System.out.println(StaticData.s2);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStaticData.f1();
		TestStaticData.f2();
	}

}
