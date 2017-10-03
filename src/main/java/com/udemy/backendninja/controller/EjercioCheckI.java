package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.ServicioLog;



@Controller
@RequestMapping("/ejercicio")
public class EjercioCheckI {

	public static final String VIEW_A = "ejemplo";
	public static final String VIEW_B = "/ejercicio/ejemplo";
	
	@Autowired
	@Qualifier("ServicioLog")
	private ServicioLog servicioLOG;
	
	@GetMapping("/ejemplo")
	public ModelAndView ejemploPrimero(){
		ModelAndView mov = new ModelAndView();
		mov.setViewName(VIEW_A);
		mov.addObject("animal", servicioLOG.getLog());
		return mov;
	}
	
	//Redireccion forma 2
	@GetMapping("/ejemplo2")
	public RedirectView redirect(){
		return new RedirectView(VIEW_B);
	}

	
}
