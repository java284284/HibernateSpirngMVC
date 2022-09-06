package tw.ispan.springdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect {

	@Before(value = "execution(* tw.ispan.springdemo.model.EnglishTeacher.*(..))")
	public void before() {
		System.out.println("before math");
	}
	
	@After(value = "execution(* tw.ispan.springdemo.model.EnglishTeacher.*(..))")
	public void after() {
		System.out.println("before math");
	}
	
//	@Around(value = "excution(* tw.ispan.springdemo.model.EnglishTeacher.*(..) )")
//	public void around() {
//		System.out.println("before math");
//	}
	

}
