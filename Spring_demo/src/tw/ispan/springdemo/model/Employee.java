package tw.ispan.springdemo.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private Integer id;
	
	private String name;
	
	private Integer vacation;

	public Employee() {
	}
	
	@PostConstruct
	public void initial() {
		vacation = 10;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVacation() {
		return vacation;
	}

	public void setVacation(Integer vacation) {
		this.vacation = vacation;
	}
	

}