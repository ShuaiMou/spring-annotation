package com.saul.bean;

public class Boss2 {
	private Car car;

	public Car getCar() { 
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
		
	}
	
	public Boss2(Car car) {
		super();
		this.car = car;
		
	}

	public Boss2() {
	
	}
	
	@Override
	public String toString() {
		return "Boss2 [car=" + car + "]";
	}
	
}
