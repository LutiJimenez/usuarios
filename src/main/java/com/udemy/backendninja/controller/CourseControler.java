package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseControler {

	private static final String COURSES_VIEW = "courses";
//	private static final String COURSES_VIE = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseControler.class);
	
	@Autowired
	private CourseConverter courseConverter;
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourse(){
		LOG.info("Call: " + "listAllCourse()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", courseService.listAllCourse());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel course){
		LOG.info("Call: " + "addCourse()" + " -- PARAM:" + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listcourses";
	}
	
	@RequestMapping(value = "/delcourse/{id}", method = RequestMethod.GET )
	public String delCourse(@PathVariable("id") int id){
		LOG.info("Call: " + "delCourse()" + " -- PARAM:" + id);
		
		courseService.removeCourse(id);
		return "redirect:/courses/listcourses";
	}
}
