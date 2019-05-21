使用@PropertySource读取外部配置文件中的key/value保存到运行的环境变量中;
加载完外部的配置文件以后使用${}取出配置文件的值.
	@PropertySource(value={"classpath:/person2.properties"})
	

	 * 使用 @Value 赋值：
	 * 1.基本数值
	 * 2.可以写SPEL；#{}
	 * 3.可以写${}; 取出配置文件【properties文件】中的值（在运行环境变量里面的值）

	@Value("张三")
	private String name;
	
	@Value("#{20-2}")
	private int age;
	
	@Value("${person2.nickName}")
	private String nickname;
	
//通过环境变量获取配置文件的值
ConfigurableEnvironment environment = context.getEnvironment();
String property = environment.getProperty("person2.nickName");