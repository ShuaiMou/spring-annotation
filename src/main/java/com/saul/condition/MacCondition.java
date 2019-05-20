package com.saul.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MacCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		//获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		//判断容器中是否包含person Bean.
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
		String property = environment.getProperty("os.name");
		//如果容器中包含person  Bean 或者是Mac系统，则条件为真，并返回
		if(property.contains("Mac") || containsBeanDefinition){
			return true;
		}
		return false;
	}

}
