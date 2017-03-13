package Array;

import java.util.Vector;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> al = new ArrayList<String>();
//		al.add("1");
//		al.add("2");
//		al.add("3");
//		al.add("4");
//		al.add("5");
//		
//		al.remove(1);
//		al.remove(2);
//		
//		for (String s:al){
//			System.out.println(s);
//		}
		
		Vector v = new Vector();
		v.add("a");
		v.add("b");
		v.add("c");
		int index = v.indexOf("b");
		System.out.println(index);
		System.out.println(v.get(index));
	}

}
