package com.saul.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person2 {
	
	/**
	 * 使用 @Value 赋值：
	 * 1.基本数值
	 * 2.可以写SPEL；#{}
	 * 3.可以写${}; 取出配置文件【properties文件】中的值（在运行环境变量里面的值）
	 */
	@Value("张三")
	private String name;
	
	@Value("#{20-2}")
	private int age;
	
	@Value("${person2.nickName}")
	private String nickname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Person2() {
		super();
	}
	
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + ", nickname=" + nickname + "]";
	}
	
	
}
