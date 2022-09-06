package tw.hibernatedemo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class javatest1 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		// 拿連線
		Session session = factory.openSession();
		
		// 開交易
		session.beginTransaction();
		
		CompanyBean com1 = new CompanyBean();
		com1.setCompanyId(1001);
		com1.setCompanyName("Google");
		
		// 轉換物件狀態
		session.save(com1);
		
		// commit
		session.getTransaction().commit();
		
		// 連線還給連線池
		session.close();
		
		// 關 Session 工廠
		factory.close();
	}

}