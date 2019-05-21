 * bean的生命周期：
 * 	bean的创建 --- 初始化 --- 销毁过程
 * 
 * 容器管理bean的生命周期；
 * 
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来
 * 调用我们自定义的初始化和销毁方法。
 * 
 * 1.构造（对象创建）
 * 		单实例： 在容器启动时创建对象
 * 		多实例： 在每次获取时创建对象
 
 * 2.postProcessBeforeInitialization 
 
 * 3.初始化：
 * 		对象创建完成，并赋值好，调用初始化方法。。。
 
 * 4.postProcessAfterInitialization
 
 * 5.销毁： 
 * 		单实例：容器关闭时
 * 		多实例：容器不会管理这个bean；容器不会调用销毁方法；
 * 
 * 1）指定初始化和销毁方法：
 * 		通过@Bean指定init-method 和 destroy-method
 *			for instance：
 *				@Bean(initMethod="init",destroyMethod="destroy")
 *				
 * 2）通过让bean实现InitializingBean(定义初始化逻辑)
 * 				DisposableBean(定义销毁逻辑)
 			for instance：
 				public class Cat implements InitializingBean, DisposableBean{}
 				
 * 3）可以使用JSR250；
 * 				@PostConstruct: 在bean创建完成并且属性赋值完成；来执行初始化方法。
 * 				@PreDestroy:在容器销毁bean之前通知我们进行清理工作。
 			for instance：
 					@PostConstruct
					public void init(){
						System.out.println("Dog...init...");
					}
 				
 * 4）BeanPostProcessor[interface]：bean的后置处理器；
 * 			在bean初始化前后进行一些处理工作；
 * 				postProcessBeforeInitialization:在初始化之前调用。
 * 				postProcessAfterInitialization:在初始化之后工作
 			for instance：
 				public class MyBeanPostProcessor implements BeanPostProcessor{}