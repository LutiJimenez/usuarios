package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HelloworldController {
	
	@GetMapping("/helloworld")
	public String helloWorld(){
		//Retornamos el nombre de la vista en Resources/templates/helloworld.html
		return "helloworld";
	}

}
