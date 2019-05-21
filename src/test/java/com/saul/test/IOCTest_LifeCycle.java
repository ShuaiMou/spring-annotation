package com.saul.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.saul.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {
	
	//测试 通过@Bean指定init-method 和 destroy-method
	@Test
	public void test1(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成。。。");
		Object bean = context.getBean("car");
		Object bean2 = context.getBean("car");
		System.out.println(bean == bean2);
		context.close();
		System.out.println("容器销毁完成。。。");
	}
	
	@Test
	public void test2(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成。。。");
		context.close();
		System.out.println("容器销毁完成。。。");
	}
}
