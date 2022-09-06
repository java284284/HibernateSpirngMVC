package tw.ispan.springdemo.action;

import tw.ispan.springdemo.model.EnglishTeacher;
import tw.ispan.springdemo.model.MathTeacher;
import tw.ispan.springdemo.model.Teacher;

public class TeacherAction {

	public static void main(String[] args) {
		Teacher teacher = new EnglishTeacher();
		teacher.teach("單字教學");

	}

}