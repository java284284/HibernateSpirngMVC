package tw.ispan.springdemo.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.Employee;

public class Demo12InitializeBeanValue {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee emp = context.getBean("employee", Employee.class);
		
		emp.setId(1);
		emp.setName("阿毛");
		
		System.out.println("name: " + emp.getName());
		System.out.println("vacation: " + emp.getVacation());
		
		context.close();
		

	}

}