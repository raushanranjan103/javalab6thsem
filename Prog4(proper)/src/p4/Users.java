package p4;

public class Users {
	String username, password;
	Users(){
		username="admin";
		password="password";
	}
	
	boolean auth(String username,String password) {
		if(this.username.equals(username) && this.password.equals(password))
			return true;
		return false;
	}
}
