package com.saul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.saul.bean.Car;

/**
 * bean的生命周期：
 * 	bean的创建 --- 初始化 --- 销毁过程
 * 
 * 容器管理bean的生命周期；
 * 
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来
 * 调用我们自定义的初始化和销毁方法。
 * 
 * 构造（对象创建）
 * 		单实例： 在容器启动时创建对象
 * 		多实例： 在每次获取时创建对象
 * 
 * 初始化：
 * 		对象创建完成，并赋值好，调用初始化方法。。。
 * 
 * 销毁： 
 * 		单实例：容器关闭时
 * 		多实例：容器不会管理这个bean；容器不会调用销毁方法；
 * 
 * 1）指定初始化和销毁方法：
 * 		通过@@Bean指定init-method 和 destroy-method
 * 
 * @author Saul
 * 2019-05-20
 *
 */
@Configuration
public class MainConfigOfLifeCycle {
	
	@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destroy")
	public Car car(){
		return new Car();
	}
}
