package com.udemy.backendninja.service.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Animal;
import com.udemy.backendninja.service.ServicioLog;

@Service("ServicioLog")
public class ServicioLogImpl implements  ServicioLog{

	private static final Log LOG = LogFactory.getLog(ServicioLogImpl.class); 
	
	@Override
	public Animal getLog(){
		LOG.info("MI SERVICIO LUTI");
		Animal animal = new Animal();
		animal.setNombre("TIGRE");
		LOG.info("El animal es: " + animal.getNombre());
		return animal;
	}
}
