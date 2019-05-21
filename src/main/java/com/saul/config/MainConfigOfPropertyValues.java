package com.saul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.saul.bean.Person2;

//使用@PropertySource读取外部配置文件中的key/value保存到运行的环境变量中;
//加载完外部的配置文件以后使用${}取出配置文件的值.
@PropertySource(value={"classpath:/person2.properties"})
@Configuration
public class MainConfigOfPropertyValues {
	
	@Bean
	public Person2 person2(){
		return new Person2();
	}
}
