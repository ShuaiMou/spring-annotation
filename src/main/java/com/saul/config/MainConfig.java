package com.saul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.saul.bean.Person;
/**
 * 配置类: 相当于原来的配置文件（xml文件）
 * 
 * @author Saul
 * 2019-05-17
 *
 *@Configuration :告诉spring这是一个配置类
 *@ComponentScan(value="com.saul") 组件扫描, value指定要扫描的包
 *@ComponentScan(value="com.saul", excludeFilters={
		@Filter(type=FilterType.ANNOTATION, classes={Controller.class,Service.class})})	
 *excludeFilters = Filter[]: 指定扫描时按照什么规则排除那些组件
 *@ComponentScan(value="com.saul", includeFilters={
		@Filter(type=FilterType.ANNOTATION, classes={Controller.class,Service.class})}, useDefaultFilters = false)
 *includeFilters = Filter[]： 指定扫描时只需要包含哪些组件(首先要关掉默认过滤)
 *
 *java8可以支持多个@ComponentScan制定策略，在之前可以用@ComponentScans(value={
 *}) value是不同的ComponentScan
 *
 */
@Configuration  
@ComponentScan(value="com.saul", includeFilters={
		@Filter(type=FilterType.ANNOTATION, classes={Controller.class,Service.class})
}, useDefaultFilters = false)
public class MainConfig {
	
	//给容器中一个Bean；类型为返回值类型， id默认是用方法名作为id
	@Bean("person")
	public Person person1(){
		return new Person("saul", 20);
	}
}
