package tw.ispan.springdemo.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.Book;

public class Demo5BookStaticFactoryAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Book book1 = context.getBean("javaBook", Book.class);
		System.out.println("book1 name: " + book1.getBookName());

		Book book2 = context.getBean("mathBook", Book.class);
		System.out.println("book2 name: " + book2.getBookName());

		context.close();

	}

}