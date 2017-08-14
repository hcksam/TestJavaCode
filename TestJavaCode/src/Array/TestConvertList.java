package Array;

import java.util.Arrays;
import java.util.LinkedList;

public class TestConvertList {
	public static void main(String[] args) {
		String[] a = {"a","b"};
		LinkedList<String> l = new LinkedList<String>(Arrays.asList(a));
		l.add("c");
		a = l.toArray(new String[0]);
		
		for (String s:a){
			System.out.println(s);
		}
		
		System.out.println("Commplete Run");
	}
}
