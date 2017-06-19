package tool;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TextConcat2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fc = new File("C:/Users/01311588/Documents/","cc.txt");
		File f1 = new File("C:/Users/01311588/Documents/","c1.txt");
		File f2 = new File("C:/Users/01311588/Documents/","c2.txt");
		
		try{
			List<String> lc = new LinkedList<String>();
			List<String> l1 = FileUtils.readLines(f1);
			List<String> l2 = FileUtils.readLines(f2);
			for (int i=0;i<l1.size();i++){
				System.out.println(i+" processing...");
				String s1 = l1.get(i);
				String s2 = l2.get(i);
				
				String sc = s1;
				sc += s2;
				lc.add(sc);
			}
			
			FileUtils.writeLines(fc, lc);
		}catch (Exception e){
			System.out.println("ERROR!");;
		}
		System.out.println("Complete run!");;
	}

}
