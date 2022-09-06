package tw.bread.com.model;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Products> getAll() {
		Session session = sessionFactory.openSession();

		String hqlstr = "from Products ";
		Query<Products> query = session.createQuery(hqlstr, Products.class);

		List<Products> list = query.getResultList();

		session.close();

		return list;

	}

	public List<Products> searchProduct(String search) {
		Session session = sessionFactory.openSession();
		String hqlstr = "from Products where name like:pname ";
		Query<Products> query = session.createQuery(hqlstr, Products.class);
		search = "%" + search + "%";
		query.setParameter("pname", search);
		List<Products> slist = query.getResultList();

		session.close();

		return slist;

	}
	
	public Products sProduct(int id) {
		Session session = sessionFactory.openSession();
		String hqlstr = "from Products where id like:id ";
		Query<Products> query = session.createQuery(hqlstr, Products.class);
		query.setParameter("id", id);
		Products p=query.getSingleResult();

		session.close();

		return p;

	}

	public Products addProduct(String name, int price,byte[] photo) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Products p = new Products();
			p.setName(name);
			p.setPrice(price);
			p.setPhoto(photo);
			session.save(p);
			return p;

		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}

	public boolean deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Products p = session.get(Products.class, id);
		if (p != null) {
			session.delete(p);
			return true;
		}

		return false;

	}
	
	public Products updateProduct(int id, String newName, int newPrice,byte[] newPhoto ) {
		Session session = sessionFactory.getCurrentSession();
		Products p = session.get(Products.class, id);
		if (p != null) {
			p.setName(newName);
			p.setPrice(newPrice);
			p.setPhoto(newPhoto);
		}

		return p;

	}
}
