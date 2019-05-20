package com.saul.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * @author Saul
 * 2019-05-20
 *
 */
public class ColorFactoryBean implements FactoryBean<Color>{

	//返回一个Color对象，这个对象会添加到容器中
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean...");
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}
	
	//true:是单实例， 在容器中保存一份
	//false： 多实例，每次获取都会创建一个新的bean
	public boolean isSingleton(){
		return true;
	}
}
