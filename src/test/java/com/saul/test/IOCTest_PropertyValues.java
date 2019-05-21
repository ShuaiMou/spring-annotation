package com.saul.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.saul.bean.Person2;
import com.saul.config.MainConfigOfPropertyValues;

public class IOCTest_PropertyValues {
	
	private void printBeans(AnnotationConfigApplicationContext context){
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	//测试 使用 @Value 赋值：
	@Test
	public void test1(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
		printBeans(context);
		Person2 person = (Person2) context.getBean("person2");
		System.out.println(person);
		
		ConfigurableEnvironment environment = context.getEnvironment();
		String property = environment.getProperty("person2.nickName");
		System.out.println(property);
	}
}
