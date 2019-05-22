package com.saul.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值操作。
@Component
public class Boss {
	private Car car;

	public Car getCar() {
		return car;
	}
	//标注在方法，spring容器创建当前对象，就会调用方法，完成赋值；
	//方法使用的参数，自定义类型的值从ioc容器中获取。
	//@Autowired
	public void setCar(Car car) {
		this.car = car;
		System.out.println("boss 的set方法。");
	}
	
	@Autowired
	public Boss(Car car) {
		super();
		this.car = car;
		System.out.println("boss 的有参构造器。");
	}
	
//	public Boss(){
//		System.out.println("boss 的无参构造器。");
//	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
}
