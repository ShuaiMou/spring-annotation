package com.saul.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.saul.bean.Person;
import com.saul.config.MainConfig;
import com.saul.config.MainConfig2;

public class IOCTest {
	
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
	
	//测试注解 ComponentScan
	@Test
	public void test2(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] names  = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	//测试 Scope("prototype")
	@Test
	public void test3(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		
		Object person1 = applicationContext.getBean("person");
		Object person2 = applicationContext.getBean("person");
		System.out.println(person1 == person2);
	}
	
	//测试 Scope("prototype")
		@Test
		public void test4(){
			@SuppressWarnings("resource")
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
			ConfigurableEnvironment environment = applicationContext.getEnvironment();
			//动态获取环境变量的值
			String property = environment.getProperty("os.name");
			System.out.println(property);
			String[] names  = applicationContext.getBeanDefinitionNames();
			for (String name : names) {
				System.out.println(name);
			}
		}
}
