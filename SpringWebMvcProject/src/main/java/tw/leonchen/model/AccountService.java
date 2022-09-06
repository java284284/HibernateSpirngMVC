package tw.leonchen.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountService implements IAccountService {
	
    @Autowired
	private IAccountDao accountDao;
	
	@Override
	public boolean checkLogin(Account users) {
		return accountDao.checkLogin(users);
	}

}
