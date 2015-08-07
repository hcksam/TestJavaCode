package Array;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		
		boolean first = true;
		
		for (String s:al){
			System.out.println(s);
			if (first){
				first = false;
				al.remove(1);
				al.remove(2);
			}
		}
	}

}
