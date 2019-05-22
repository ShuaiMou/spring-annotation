package com.saul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.saul.service.AutowiredService;

@Controller
public class AutowiredController {
	
	@Autowired
	private AutowiredService autowiredService;

	@Override
	public String toString() {
		return "AutowiredController [autowiredService=" + autowiredService + "]";
	}
	
	
}
