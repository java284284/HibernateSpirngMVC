package tw.ispan.springdemo.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.LightBean;

public class Demo10PropertiesFileAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		LightBean lightBean = context.getBean("light", LightBean.class);
		
		System.out.println("id: " + lightBean.getId());
		System.out.println("red light time: " + lightBean.getRed());
		System.out.println("Green light time: " + lightBean.getGreen());
		System.out.println("Yellow light time: " + lightBean.getYellow());
	
		context.close();

	}

}