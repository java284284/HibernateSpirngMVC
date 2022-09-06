package tw.bread.com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDAO uDao;
	
	public  Users checkLogin(Users u) {
		return uDao.checkLogin(u);
	}
	
	public Users Sign(String phone, String name,String birthday,String pid,String pwd) {
		return uDao.Sign(phone, name, birthday, pid, pwd);
	}

}
