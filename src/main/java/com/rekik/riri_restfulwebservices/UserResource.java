package com.rekik.riri_restfulwebservices;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;


@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {

		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id -"+id);
		return service.findOne(id);
	}

	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {

		User savedUser = service.save(user);
		//status of the created
		// how to set the uri of the created resource into the response

		//create uri first
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getIdInteger())
				.toUri();

		return ResponseEntity.created(location).build();


	}


	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id -"+id);
	}



}