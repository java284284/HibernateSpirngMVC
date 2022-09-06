package tw.ispan.springdemo.model;

public class MathTeacher implements Teacher {

	@Override
	public void teach(String content) {
		System.out.println("數學教學: " + content);

	}

}