package tw.bread.com.model;

import javax.persistence.NoResultException;

import org.apache.catalina.User;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Users checkLogin(Users u) {
		Session session = sessionFactory.openSession();

		String hqlstr = "from Users where phone=:phone and pwd=:pwd";
		Query<Users> query = session.createQuery(hqlstr, Users.class);
		query.setParameter("phone",u.getPhone());
		query.setParameter("pwd", u.getPwd());
		
		Users u1 = query.uniqueResult();
		session.close();

		if (u1 != null) {
			return u1;
		}

		return null;

	}
	
	public Users Sign(String phone, String name,String birthday,String pid,String pwd) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Users u=new Users();
			u.setPhone(phone);
			u.setName(name);
			u.setBirthday(birthday);
			u.setPid(pid);
			u.setPwd(pwd);
			session.save(u);
			return u;
			
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}	
	

}
