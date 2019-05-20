1.@Scope("prototype") //调整作用域
	 * PROTOTYPE: 多实例, 每次获取的时候才会调用方法创建对象。
	 * SINGLETON： 单实例 (默认值),ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取直接从容器(map.get())中拿。
	 * 后面两个基本不用：
	 * REQUEST: 同一次请求创建一个实例
	 * SESSION：同一个session创建一个实例
	 
2.@Lazy //懒加载，延迟加载
 	* 单实例bean是默认在容器创建时创建对象。懒加载使其在第一次使用（获取）bean时才创建对象，并初始化。
 
3. @Conditional({condition}): 按照一定条件进行判断，满足条件给容器注册Bean.
	*@Conditional({MacCondition.class}), 其中MacCondition类需要实现Condition接口.
	*当@Conditional注解放到类前面时，需要满足此条件，这个类中配置的所有bean注册才能生效.


4.给容器中注册组件：
	 * 1）包扫描 + 组件标注注解（@Controller/@Service/@Repository/@Component）[局限于自己写的类]
	 * 2）@Bean [导入的第三方包里面的组件]
	 * 3）@Import [快速给容器中导入一个组件]
	 * 		1）@Import(要导入容器中的组件)；容器会自动注册这个组件，id默认是组件的全类名。
	 * 		2）ImportSelector：返回需要导入的组件的全类名数组
	 *  	3）ImportBeanDefinitionRegistrar: 手动注册bean到1容器中
	 * 4）使用Spring提供的FactoryBean（工厂Bean）
	 * 		1）默认获取到的是工厂bean调用getObject创建的对象
	 * 		2）要获取工厂bean本身，我们需要给id前加一个&，例子：&ColorFactoryBean
	