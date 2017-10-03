package com.udemy.backendninja.controller;

import javax.validation.Valid;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	
	//Propios Logs.
	//private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	public static final String FORM_VIEW  = "form";
	public static final String RESULT_VIEW = "result";
	
	//Redirección forma 1
/*	@GetMapping("/")
	public String redirect(){
		return "redirect:/example3/showform";
	}*/
	
	//Redireccion forma 2
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model){
/*		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING_TRACE");
		LOGGER.error("ERROR_TRACE");
		LOGGER.debug("DEBUG_TRACE");*/
		model.addAttribute("person", new Person());
		//int i = 6 / 0;
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
		ModelAndView mov = new ModelAndView();
		if(bindingResult.hasErrors()){
			mov.setViewName(FORM_VIEW);
		}
		else{
			mov.setViewName(RESULT_VIEW);
			mov.addObject("person", person);
		}
		//LOGGER.info("METHOD: 'addPerson' -- PARAM:" + person );
		
		
		//LOGGER.info("Template: " + RESULT_VIEW + " --DATA: " + person);
		return mov;
		
	}
}
