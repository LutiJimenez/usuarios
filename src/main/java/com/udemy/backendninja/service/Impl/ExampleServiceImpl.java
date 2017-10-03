package com.udemy.backendninja.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class); 
	
	
	@Override
	public List<Person> getListPeople() {
				
			List<Person> people = new ArrayList<>();
			people.add(new Person("Luti", 34));
			people.add(new Person("Ana", 33));
			people.add(new Person("Mario", 2));
			LOG.info("HELLO FORM SERVICE");
			return people;
		
	}

}
