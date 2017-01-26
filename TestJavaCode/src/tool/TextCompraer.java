package tool;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TextCompraer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("C:/Users/01311588/Documents/","test1.csv");
		File f2 = new File("C:/Users/01311588/Documents/","test2.csv");
		
		try{
			List<String> l1 = FileUtils.readLines(f1);
			List<String> l2 = FileUtils.readLines(f2);
			for (int i=0;i<l1.size();i++){
				System.out.println(i+" processing...");
				if (!l1.get(i).equals(l2.get(i))){
					System.out.println("Diff! "+i+"(file1): "+l1.get(i));
					System.out.println("Diff! "+i+"(file2): "+l2.get(i));
					break;
				}
			}
		}catch (Exception e){
			
		}
		System.out.println("Complete run!");;
	}

}
