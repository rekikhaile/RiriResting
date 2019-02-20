package com.rekik.riri_restfulwebservices;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{name}")
	public String helloWorld(@PathVariable String name) {
		return "Hi there "+name;
	}

	@RequestMapping(method=RequestMethod.GET, value="/helloIntl")
	public String helloWorldInternationalization(@PathVariable String name) {
		return "Good Morning";
	}

}
