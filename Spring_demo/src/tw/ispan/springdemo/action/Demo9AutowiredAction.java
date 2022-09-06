package tw.ispan.springdemo.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.CompanySoGo;

public class Demo9AutowiredAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CompanySoGo sogo = context.getBean("companySoGo", CompanySoGo.class);
		
		sogo.userCard();
		
		context.close();

	}

}