package com.udemy.backendninja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		ContactModel cm = new ContactModel(2, "PPPP", "PPPP", "12312312", "Madrid");
		//return new ResponseEntity<String>("OK", HttpStatus.OK);
		return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
	}
}
