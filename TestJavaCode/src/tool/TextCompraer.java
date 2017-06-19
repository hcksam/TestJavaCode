package tool;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TextCompraer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File f1 = new File("C:/Users/01311588/Documents/","test1.csv");
//		File f2 = new File("C:/Users/01311588/Documents/","test2.csv");
//		File f1 = new File("D:/Temp/FTP/uat/CR2017002/","test7.csv");
//		File f2 = new File("D:/Temp/FTP/uat/CR2017002/","test8.csv");
		File f1 = new File("C:/working/pccw-srm/workspace/test/ftp/","SP_CBA_NewCSLReport.csv");
		File f2 = new File("C:/working/pccw-srm/workspace/test/ftp/","SP_CBA_NewCSLReport_20170427.csv");
		
		
		try{
			List<String> l1 = FileUtils.readLines(f1);
			List<String> l2 = FileUtils.readLines(f2);
			for (int i=0;i<l1.size();i++){
				System.out.println(i+" processing...");
				String s1 = l1.get(i);
				String s2 = l2.get(i);
				
				if (s1.contains("BPM0"))
					continue;
				
				if (!s1.equals(s2)){
					System.out.println("Diff! "+i+"(file1): "+l1.get(i));
					System.out.println("Diff! "+i+"(file2): "+l2.get(i));
					break;
				}
			}
		}catch (Exception e){
			System.out.println("ERROR!");;
		}
		System.out.println("Complete run!");;
	}

}
