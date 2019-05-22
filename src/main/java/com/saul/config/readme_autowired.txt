/**
 * 自动装配：
 * 		Spring利用依赖注入(DI)，完成对IOC容器中的各个组件的依赖关系赋值.
 * 
 * 1) @Autowired:自动注入：
 * 		AutowiredService {
			@Autowired
			AutowiredDao autowiredDao2;
		}
 * 			1）默认优先按照类型去容器中找对应的组件：ApplicationContext.getBean(AutowiredDao.class)，找到就赋值。
 * 			2) 如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找。ApplicationContext.getBean("autowiredDao2").
 * 			3)  @Qualifier("autowiredDao"): 使用@Qualifier指定需要装配的组件的id，而不是使用属性名。
		 * 			   @Qualifier("autowiredDao")
					   @Autowired
					   AutowiredDao autowiredDao2;
			4）自动装配默认一定要将属性赋值好，没有就会报错；
 * 				可以使用@Autowired(required=false)
 * 			5) @Primary: 让spring进行自动装配的时候，默认使用首选的bean。
 * 						也可以继续使用@Qualifier指定需要装配的bean的名字。
 * 2）spring还支持@Resource 和 @Inject【java规范的注解】
 * 			1）@Resource：
 * 					可以和@Autowired一样实现自动装配功能，默认是按照组件名称进行装配的；
 * 					不能支持@Primary功能和@Autowired(required=false)功能。
 * 			2）@Inject：
 * 					需要导入javax.inject的包，和@Autowired的功能一样。没有 required=false 功能。
 * 			@Autowired：spring定义的； @Resource 和 @Inject 都是java规范
 
 * 3）@Autowired： 构造器，参数，方法，属性位置标注。都是从容器中获取参数组件的值
 * 			1)标注在方法上: @Bean + 方法参数；参数从容器中获取。
 * 				//标注在方法，spring容器创建当前对象，就会调用方法，完成赋值；
				//方法使用的参数，自定义类型的值从ioc容器中获取。
				@Autowired
				public void setCar(Car car) {
					this.car = car;
				}
				
				@Bean
				public Boss2 boss2(Car car){
					Boss2 boss2 = new Boss2();
					boss2.setCar(car);
					return boss2;
				}
 * 			2）标在构造器上： 如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取。
 * 				@Autowired
				public Boss(Car car) {
					super();
					this.car = car;
					System.out.println("boss 的有参构造器。");
				}
 * 			3）标在参数上 
 * 				public void setCar(@Autowired Car car) {
					this.car = car;
				}