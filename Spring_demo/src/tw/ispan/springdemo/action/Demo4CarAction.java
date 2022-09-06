package tw.ispan.springdemo.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.ispan.springdemo.model.Car;

public class Demo4CarAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Car car1 =  (Car) context.getBean("car1");
		
		System.out.println(car1.getCarId());
		System.out.println(car1.getCarName());
		System.out.println(car1.getBrand());
		
		Car car2 =  (Car) context.getBean("car2");
		System.out.println("Release Date: " + car2.getReleaseDate());
		
		Car car3 = (Car) context.getBean("car3");
		System.out.println("id3: " + car3.getCarId());
		System.out.println("name3: " + car3.getCarName());
		System.out.println("Brand3: " + car3.getBrand());
		System.out.println("Release Date3: " + car3.getReleaseDate());
		
		context.close();

	}

}