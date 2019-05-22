package com.saul.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.saul.bean.Boss;
import com.saul.bean.Boss2;
import com.saul.bean.Car;
import com.saul.config.MainConfigOfAutowired;
import com.saul.dao.AutowiredDao;
import com.saul.service.AutowiredService;

public class IOCTest_autowired {
	@Test
	public void test1(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		AutowiredService service = (AutowiredService) context.getBean("autowiredService");
		System.out.println(service);
		AutowiredDao dao = (AutowiredDao) context.getBean("autowiredDao");
		System.out.println(dao);
		context.close();
	}
	
	@Test
	public void test2(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		Boss boss = (Boss) context.getBean("boss");
		System.out.println(boss);
		Car car = (Car) context.getBean("car");
		System.out.println(car);
		context.close();
	}
	
	@Test
	public void test3(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		
		Boss boss = (Boss) context.getBean("boss");
		System.out.println(boss);
		Car car = (Car) context.getBean("car");
		System.out.println(car);
		Boss2 boss2 = (Boss2) context.getBean("boss2");
		System.out.println(boss2);
		context.close();
	}
	
}
