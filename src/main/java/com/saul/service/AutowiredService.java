package com.saul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saul.dao.AutowiredDao;

@Service
public class AutowiredService {
	
	//@Qualifier("autowiredDao3")
	@Autowired(required=false)
	private AutowiredDao autowiredDao2;
	
	public void print(){
		System.out.println(autowiredDao2);
	}

	@Override
	public String toString() {
		return "AutowiredService [autowiredDao=" + autowiredDao2 + "]";
	}
	
	
}
