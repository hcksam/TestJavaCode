package connect;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class URLAuthenticator extends Authenticator {  
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
