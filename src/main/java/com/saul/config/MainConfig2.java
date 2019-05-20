package com.saul.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.saul.bean.Color;
import com.saul.bean.ColorFactoryBean;
import com.saul.bean.Person;
import com.saul.condition.LinuxCondition;
import com.saul.condition.MacCondition;
import com.saul.condition.MyImportBeanDefinitionRegistrar;
import com.saul.condition.MyImportSelector;

@Configuration
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class}) //导入组件
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
	
	/**
	 * 给容器中注册组件：
	 * 1）包扫描 + 组件标注注解（@Controller/@Service/@Repository/@Component）[局限于自己写的类]
	 * 2）@Bean [导入的第三方包里面的组件]
	 * 3）@Import [快速给容器中导入一个组件]
	 * 		1）@Import(要导入容器中的组件)；容器会自动注册这个组件，id默认是组件的全类名。
	 * 		2）ImportSelector：返回需要导入的组件的全类名数组
	 *  	3）ImportBeanDefinitionRegistrar: 手动注册bean到1容器中
	 * 4）使用Spring提供的FactoryBean（工厂Bean）
	 * 		1）默认获取到的是工厂bean调用getObject创建的对象
	 * 		2）要获取工厂bean本身，我们需要给id前加一个&，例子：&ColorFactoryBean
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
}
