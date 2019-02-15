package com.rekik.riri_restfulwebservices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{name}")
	public String helloWorld(@PathVariable String name) {
		return "Hi there "+name;
	}
	
	

}
