package tw.hibernatedemo.model;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	private SessionFactory factory;
	
	
	public MyMember findByUsernameAndPassword(String username, String pwd) {
		Session session = factory.getCurrentSession();
		
		String hql = "from MyMember m where m.memberName = :name and m.memberPwd = :pwd";
		
		try {
			MyMember result = session.createQuery(hql, MyMember.class)
					.setParameter("name", username)
					.setParameter("pwd", pwd)
					.getSingleResult();
			return result;
		}catch(NoResultException | NonUniqueResultException e) {
			return null;
		}
		
	}
	

}
