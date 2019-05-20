package com.saul.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.saul.bean.Rainbow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

		/**
		 * AnnotationMetadata: 当前类的注解信息
		 * BeanDefinitionRegistry： BeanDefinition注册类;
		 * 		把所有需要添加到容器中的bean；调用
		 * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
		 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("com.saul.bean.Blue");
		boolean definition2 = registry.containsBeanDefinition("com.saul.bean.Red");
		if (definition && definition2) {
			//注册一个Bean，指定bean名
			//指定Bean的定义信息（Bean的类型，作用域等）
			registry.registerBeanDefinition("rainbow", new RootBeanDefinition(Rainbow.class));
		}
		
	}

}
