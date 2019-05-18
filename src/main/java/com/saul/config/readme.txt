 配置类: 相当于原来的配置文件（xml文件）

	1. @Configuration :告诉spring这是一个配置类
	 
	2. @ComponentScan(value="com.saul") 组件扫描, value指定要扫描的包
	   excludeFilters = Filter[]: 指定扫描时按照什么规则排除那些组件
	   includeFilters = Filter[]： 指定扫描时只需要包含哪些组件(首先要关掉默认过滤)
	 	  Example：
			   @ComponentScan(value="com.saul", excludeFilters={
				  @Filter(type=FilterType.ANNOTATION, classes={Controller.class,Service.class})})	
	 
			   @ComponentScan(value="com.saul", includeFilters={
				  @Filter(type=FilterType.ANNOTATION, classes={Controller.class,Service.class})}, useDefaultFilters = false)
	
	3. java8可以支持多个@ComponentScan制定策略，在之前可以用@ComponentScans(value={}) 
			value是不同的ComponentScan
		Example:
			@ComponentScans(value={
				@ComponentScan(value="com.saul", excludeFilters={
				   @Filter(type=FilterType.ANNOTATION, classes={Controller.class,Service.class})}),
				@ComponentScan(value="com.saul", includeFilters={
				   @Filter(type=FilterType.ANNOTATION, classes={Controller.class,Service.class})}, useDefaultFilters = false)
				}) 
				
	4.FilterType.ANNOTATION: 按照注解
	  FilterType.ASSIGNABLE_TYPE: 按照给定类型(其子类都在其中)
	  FilterType.CUSTOM: 自定义规则
	  	Example:
	  		@ComponentScan(value = "com.saul", excludeFilters = {
				@Filter(type=FilterType.ANNOTATION, classes={Controller.class}),
				@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={PersonService.class})
			})
			
			@see class MyTypeFilter
				@ComponentScan(value = "com.saul", includeFilters = {
					//@Filter(type=FilterType.ANNOTATION, classes={Controller.class}),
					//@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={PersonService.class}),
					@Filter(type=FilterType.CUSTOM, classes={MyTypeFilter.class})
						},useDefaultFilters=false)}
	  