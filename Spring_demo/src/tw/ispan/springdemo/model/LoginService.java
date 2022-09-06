package tw.ispan.springdemo.model;

public class LoginService {
	
	private LoginDao loginDao;

	public LoginService() {
	}
	
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public boolean checkLogin(String username, String pwd) {
		return loginDao.checkLogin(username, pwd);
	}

}