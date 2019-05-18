package com.saul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.saul.bean.Person;
import com.saul.service.PersonService;
/**
 * 配置类: 相当于原来的配置文件（xml文件）
 * 
 * @author Saul
 * 2019-05-17
 *
 */
@Configuration  //告诉spring这是一个配置类
@ComponentScan(value = "com.saul", includeFilters = {
		//@Filter(type=FilterType.ANNOTATION, classes={Controller.class}),
		//@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={PersonService.class}),
		@Filter(type=FilterType.CUSTOM, classes={MyTypeFilter.class})
},useDefaultFilters=false)// 组件扫描, value指定要扫描的包
public class MainConfig {
	
	//给容器中一个Bean；类型为返回值类型， id默认是用方法名作为id
	@Bean("person")
	public Person person1(){
		return new Person("saul", 20);
	}
}
