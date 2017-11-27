package Loop;

import java.util.Date;

public class TestLoop {
	public static void main(String[] args){
		System.out.println("Start: "+new Date());
		int ss = new Date().getSeconds();
		int se = new Date().getSeconds();
		while (se - ss < 10){
			se = new Date().getSeconds();
		}
		System.out.println("End: "+new Date());
	}
}
