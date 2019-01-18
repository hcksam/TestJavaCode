package Set;

import java.util.HashSet;

public class TestSet {
	public static void main(String[] args){
		Bean1 a = new Bean1();
		a.setA1("a");
		a.setB1("b");
		Bean1 b = new Bean1();
		b.setA1("a");
		b.setB1("b");
		Bean1 c = new Bean1();
		c.setA1("b");
		c.setB1("a");
		
		HashSet<Bean1> ts = new HashSet<Bean1>();
		ts.add(a);
		System.out.println(ts.add(b));
		System.out.println(ts.add(c));
		System.out.println(a.equals(b));
	}
}
