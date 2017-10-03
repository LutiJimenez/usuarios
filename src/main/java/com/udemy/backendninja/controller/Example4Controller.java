package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	public static final String ERROR_VIEW = "404";
	
	@GetMapping("/error")
	public String Error(){
		return ERROR_VIEW;
	}
	
}
