package tw.ispan.springdemo.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.CreditCard;

public class Demo8CardComponentAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CreditCard card = context.getBean("creditCardGoGo", CreditCard.class);
		
		card.userCard("購物");
		
		context.close();

	}

}