package com.saul.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.saul.bean.Person;
import com.saul.condition.LinuxCondition;
import com.saul.condition.MacCondition;

@Configuration
public class MainConfig2 {
	
	/**
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * 
	 * PROTOTYPE: 多实例, 每次获取的时候才会调用方法创建对象。
	 * SINGLETON： 单实例 (默认值),ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取直接从容器(map.get())中拿。
	 * 后面两个基本不用：
	 * REQUEST: 同一次请求创建一个实例
	 * SESSION：同一个session创建一个实例
	 * 
	 * 懒加载: 单实例bean是默认在容器创建时创建对象。懒加载使其在第一次使用（获取）bean时才创建对象，并初始化。
	 */
	@Scope("prototype") //调整作用域
	@Lazy
	@Bean("person") //默认是单实例的
	public Person person(){
		return new Person("Joey",25);
	}
	
	/**
	 * @Conditional({condition}): 按照一定条件进行判断，满足条件给容器注册Bean
	 * 
	 * 如果是mac os，给容器注册("Bill")
	 * 如果是linux，给容器注册("linus")
	 */
	@Conditional({MacCondition.class})
	@Bean("bill")
	public Person person01(){
		return new Person("Bill gate", 62);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 45);
	}
	
}
