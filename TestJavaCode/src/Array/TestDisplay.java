package Array;

import java.util.LinkedList;
import java.util.List;

public class TestDisplay {
	public static String listToString(List<String> list) throws Exception{
		String str = "[ ";
		for (String s:list){
			str += "\""+s+"\",";
		}
		str = str.substring(0, str.length()-1);
		str += " ]";
		return str;
	}
	
	public static void main(String[] args) throws Exception{
		List<String> l = new LinkedList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		
		System.out.println(TestDisplay.listToString(l));
	}
}
