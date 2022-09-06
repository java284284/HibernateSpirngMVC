package tw.ispan.springdemo.model;

import java.util.Date;

public class Car {

	private Integer carId;

	private String carName;

	private String brand;
	
	private Date releaseDate;

	public Car() {
	}

	public Car(Integer carId, String carName, String brand) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.brand = brand;
	}
	
	public Car(Date releaseDate) {
		super();
		this.releaseDate = releaseDate;
	}
	

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}