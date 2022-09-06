package tw.ispan.springdemo.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.LoginService;

public class Demo3ServiceAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		LoginService service = context.getBean("loginService2", LoginService.class);
		
		boolean result = service.checkLogin("jerry", "pwdd");
		
		System.out.println("result: " + result);
		
		context.close();

	}

}