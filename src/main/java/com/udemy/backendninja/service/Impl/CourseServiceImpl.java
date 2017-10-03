package com.udemy.backendninja.service.Impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseJPARepository;
import com.udemy.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	@Autowired
	private CourseConverter courseConverter;
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJPARepository courseJpaRepository;

	@Override
	public List<Course> listAllCourse() {
		LOG.info("Call ServicIMPL: " + "listAllCourse()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(CourseModel course) {
		LOG.info("Call ServicIMPL: " + "addCourse()" + "-- PARAM: " + course.toString());
		
		return courseJpaRepository.save(courseConverter.modelToEntity(course));
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(CourseModel course) {
		return courseJpaRepository.save(courseConverter.modelToEntity(course));
	}

}
