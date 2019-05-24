package com.saul.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.saul.aop.MathCaculator;
import com.saul.config.MainConfigOfAOP;

public class IOCTest_AOP {
	@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCaculator mathCaculator = context.getBean(MathCaculator.class);
		mathCaculator.div(1, 2);
		context.close();
	}
}
