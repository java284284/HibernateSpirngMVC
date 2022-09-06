package tw.ispan.springdemo.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.Teacher;

public class Demo1XmlAction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Teacher teacher = context.getBean("teacher1", Teacher.class);
		teacher.teach("授課");
		
		
		String myString = context.getBean("string0", String.class);
		System.out.println("myString: " + myString);
		
		String myString1 = context.getBean("string1", String.class);
		System.out.println("myString1: " + myString1);
		
		String myString2 = context.getBean("string2", String.class);
		System.out.println("myString2: " + myString2);
		
		((ConfigurableApplicationContext) context).close();

	}

}