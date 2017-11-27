package connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class TestConnectWithPassword {
	public static void main1(String link, String user, String password){
		Authenticator.setDefault(new URLAuthenticator(user, password));
		
		URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
		try {
            url = new URL(link);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
        	System.out.println(ioe);
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
	}
	
	public static void main2(String link, String user, String password, String outFile) throws Exception{
		URLConnecter uc = new URLConnecter(user, password);
		uc.download(link, outFile);
	}
	
	public static void main(String[] args) throws Exception{
		String procOrderDate = "201705";
		
//		String remotePath = "http://10.1.118.241/ReportHome/MobileMkt/";
//		String remotePath = "http://ddns.toraou.com:8888/download/";
		String remotePath = "http://10.37.121.107:8081/war.srm.batch/";
		String outPath = "C:/working/pccw-srm/workspace/test/ftp/";
		
//		String fileName = procOrderDate+" Mobile.CSV";
//		String fileName = "test5.csv";
		String fileName = "war.srm.batch.war";
		
		String remoteFileName = URLConnecter.encode(fileName);
		String outFileName = fileName.replace(' ', '_');
		
		String link = remotePath+remoteFileName;
		String outFile = outPath+outFileName;
		
//		String user = "CSLMOB";
//		String password = "Csl2014u";
		String user = null;
		String password = null;
		
		main2(link, user, password, outFile);
		
		System.out.println("All Commplete");
		System.out.println(new Date());
	}
}
