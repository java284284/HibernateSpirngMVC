package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PictureDao {
	@Autowired
    private SessionFactory factory;
	
	public Picture insert(Picture p) {
		Session session = factory.openSession();
		
		if(p!=null) {
			session.save(p);
		}
		
		session.close();		
		return p;
	}
}
