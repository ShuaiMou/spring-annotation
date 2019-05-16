package com.saul.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.saul.bean.Person;
import com.saul.config.MainConfig;

public class MainTest {
	
	//测试注解 Configuration and Bean
	@Test
	public void test1(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		//返回bean的名字
		String[] nameForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : nameForType) {
			System.out.println(name);
		}
	}
}
