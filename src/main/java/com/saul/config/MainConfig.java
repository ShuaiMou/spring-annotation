package com.saul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.saul.bean.Person;

//配置类: 相当于原来的配置文件（xml文件）
@Configuration  //告诉spring这是一个配置类
@ComponentScan(value="com.saul")//组件扫描
public class MainConfig {
	
	//给容器中一个Bean；类型为返回值类型， id默认是用方法名作为id
	@Bean("person")
	public Person person1(){
		return new Person("saul", 20);
	}
}
