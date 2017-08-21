package connect;

import java.io.File;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class URLConnecter {
	public final static int TIMEOUT_CONNECT = 60000;
	public final static int TIMEOUT_READ = 60000;
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
	
	public void download(String link, String outFile) throws Exception{
		download(link, new File(outFile));
	}
	
	public void download(String link, File outFile) throws Exception{
		System.out.println(new Date());
		System.out.println("Start download "+outFile.getAbsolutePath()+" from "+link+" ...");
		
		URL url = new URL(link);
		boolean done = false;
		int retryCount = 0;
		
		while (!done){
			try {
				FileUtils.copyURLToFile(url, outFile, connectTimeout, readTimeout);
				done = true;
			} catch (SocketTimeoutException ste){
				done = false;
				if (retryCount >= retryLimit){
					ste.printStackTrace();
					throw ste;
				}
				retryCount++;
				System.out.println("Timeout");
				System.out.println("Connection timeout(ms): "+connectTimeout);
				System.out.println("Read timeout(ms): "+readTimeout);
				System.out.println("Remaining retry count: "+(retryLimit-retryCount));
			}
		}
		System.out.println("Download complete");
		System.out.println(new Date());
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
