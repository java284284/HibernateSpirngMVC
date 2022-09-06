package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDao implements IAccountDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public boolean checkLogin(Account users) {
		Session session = sessionFactory.openSession();
		
		String hqlstr = "from Account where username=:user and userpwd=:pwd";
		Query<Account> query = session.createQuery(hqlstr, Account.class);
		query.setParameter("user", users.getUsername());
		query.setParameter("pwd", users.getUserpwd());
		
		Account account = query.uniqueResult();
		session.close();
		
		if(account!=null) {
			return true;
		}
		
		return false;

	}
}
