package String;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class makeUpStringInLine {
	public static void main(String[] args){
		String s = "";
		try {
			FileInputStream fis = new FileInputStream("C:/temp/test.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				if (readLine.trim().length() > 0) {
					s+=readLine+"\n";
				}
			}
			br.close();
			isr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		System.out.println(s.replaceAll("\n\r","").replaceAll("\n",""));
		
	}
}
