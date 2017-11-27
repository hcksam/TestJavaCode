package connect;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class URLConnecter {
	public final static int TIMEOUT_CONNECT = 10000;
	public final static int TIMEOUT_READ = TIMEOUT_CONNECT;
	public final static int RETRY_LIMIT = 5;
	
	private int connectTimeout = TIMEOUT_CONNECT;
	private int readTimeout = TIMEOUT_READ;
	private int retryLimit = RETRY_LIMIT;
	
	private URLAuthenticator authenticator;
	
	public URLConnecter() {
		init(null, null, null, null, null);
	}
	
	public URLConnecter(int readTimeout) {
		init(null, readTimeout, null, null, null);
	}

	public URLConnecter(String user, String password) {
		init(null, null, null, user, password);
	}
	
	public URLConnecter(int readTimeout, String user, String password) {
		init(null, readTimeout, null, user, password);
	}
	
	public URLConnecter(Integer connectTimeout, Integer readTimeout, Integer retryLimit, String user, String password) {
		init(connectTimeout, readTimeout, retryLimit, user, password);
	}
	
	public void init(Integer connectTimeout, Integer readTimeout, Integer retryLimit, String user, String password){
		if (connectTimeout != null){
			this.connectTimeout = connectTimeout;
		}
		if (readTimeout != null){
			this.connectTimeout = readTimeout;
		}
		if (retryLimit != null){
			this.connectTimeout = retryLimit;
		}
		setAuthenticator(user, password);
	}
	
	public static String encode(String s) throws Exception{
		return URLEncoder.encode(s, "UTF-8").replace("+", "%20");
	}
	
	public static String getURLFileSize(String link) throws Exception{
		URL url = new URL(link);
		return getURLFileSize(url);
	}
	
	public static String getURLFileSize(URL url) throws Exception{
		String fileSize = null;
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		if (uc.getResponseCode() == HttpURLConnection.HTTP_OK){
			fileSize = uc.getHeaderField("content-Length");
		}
		return fileSize;
	}
	
//	public void connect(String link) throws Exception{
//		Authenticator.setDefault(authenticator);
//		
//		URL url;
//        InputStream is = null;
//        BufferedReader br;
//        String line;
//		try {
//            url = new URL(link);
//            is = url.openStream();
//            br = new BufferedReader(new InputStreamReader(is));
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (MalformedURLException mue) {
//             mue.printStackTrace();
//             throw mue;
//        } catch (IOException ioe) {
//             ioe.printStackTrace();
//             throw ioe;
//        } finally {
//            try {
//                if (is != null) is.close();
//            } catch (IOException ioe) {
//            	throw ioe;
//            }
//        }
//	}
	
	public Exception download(String link, String outFile) throws Exception{
		return download(link, new File(outFile));
	}
	
	public Exception download(String link, File outFile) throws Exception{
		URL url = new URL(link);
		boolean done = false;
		boolean retry = true;
		int retryCount = 0;
		String fileSize = null;
		Exception e = null;
		
		while (!done){
			try {
				System.out.println(new Date());
				System.out.println("Start download "+outFile.getAbsolutePath()+" from "+link+" ...");
				fileSize = getURLFileSize(url);
				if (fileSize != null){
					System.out.println("File size: "+fileSize);
					System.out.println("");
				}
				FileUtils.copyURLToFile(url, outFile, connectTimeout, readTimeout);
				if (String.valueOf(outFile.length()).equals(fileSize)){
					done = true;
				}else{
					System.out.println("File size not match!");
					System.out.println("Network file size: "+fileSize);
					System.out.println("Local file size: "+outFile.length());
				}
			} catch (ConnectException ce){
				e = ce;
				System.out.println("Connection Fail!");
			} catch (SocketTimeoutException ste){
				e = ste;
				System.out.println("Timeout");
				System.out.println("Connection timeout(ms): "+connectTimeout);
				System.out.println("Read timeout(ms): "+readTimeout);
			} catch (FileNotFoundException fnfe){
				e = fnfe;
				retry = false;
				System.out.println("File not find!");
			}
			
			if (!done){
				if (!retry || retryCount >= retryLimit){
					break;
				}
				retryCount++;
				System.out.println("Remaining retry count: "+(retryLimit-retryCount));
				TimeUnit.SECONDS.sleep(5);
			}
		}
		
		if (done){
			e = null;
			System.out.println("Download complete");
			System.out.println(new Date());
		}else{
			System.out.println("Download fail");
			System.out.println(new Date());
		}
		
		return e;
	}
	
	public void setAuthenticator(String user, String password){
		if (user == null || password == null) {
	    	authenticator = null;
	    } else {
	    	authenticator = new URLAuthenticator(user, password);
	    }
		Authenticator.setDefault(authenticator);
	}
	
	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public int getRetryLimit() {
		return retryLimit;
	}

	public void setRetryLimit(int retryLimit) {
		this.retryLimit = retryLimit;
	}

	public String getUser(){
		if (authenticator != null){
			return authenticator.getUser();
		}else{
			return null;
		}
	}
	
	public String getPassword(){
		if (authenticator != null){
			return authenticator.getPassword();
		}else{
			return null;
		}
	}
	
	class URLAuthenticator extends Authenticator {
	    private String user;
	    private String password;
	    
	    public URLAuthenticator(String user, String password){
	    	super();
	    	this.user = user;
	    	this.password = password;
	    }

	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(user, password.toCharArray());
	    }

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
}
