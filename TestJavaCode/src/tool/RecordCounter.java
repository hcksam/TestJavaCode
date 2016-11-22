package tool;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RecordCounter {
	public static void main(String[] args) {
		try{
			int count = 0;
			File allFile = new File("D:/Temp/FTP/uat/CR2016013/tmp");
			for (File file:allFile.listFiles()){
				List<String> data = FileUtils.readLines(file);
				count+=data.size()-1;
			}
			System.out.println(count);
		}catch(Exception e){
			
		}
	}
}
