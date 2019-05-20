package com.saul.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.saul.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {
	
	//测试
	@Test
	public void test1(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成。。。");
		Object bean = context.getBean("car");
		//Object bean2 = context.getBean("car");
		System.out.println(bean.getClass());
		context.close();
	}
}
