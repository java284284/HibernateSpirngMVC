package tw.ispan.springdemo.model;

public class LoginDao {

	public LoginDao() {
	}
	
	public boolean checkLogin(String username, String pwd) {
		if("jerry".equals(username) && "pwdd".equals(pwd)) {
			return true;
		}
		return false;
	}

}