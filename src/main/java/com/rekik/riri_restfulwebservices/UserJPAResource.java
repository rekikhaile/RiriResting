package com.rekik.riri_restfulwebservices;

import com.rekik.riri_restfulwebservices.exception.UserNotFoundException;
import com.rekik.riri_restfulwebservices.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
public class UserJPAResource {

	@Autowired
	private UserDaoService service;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {

		//return service.findAll();
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	//public User retrieveUser(@PathVariable int id) {
	public Resource<User> retrieveUser(@PathVariable int id) {

		//User user = userRepository.findById(id).get();
		Optional<User> user = userRepository.findById(id);

		//if(user==null)
		if(!user.isPresent())
			throw new UserNotFoundException("id -"+id);

		//you can also tell way to find "all-users" with HATEOAS - links using the methods e.g retrieveAllUsers
		//"all-users", SERVER_PATH + "/users"

		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));
		//return user;
		return resource;
	}

	@PostMapping("/jpa/users")
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


	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id -"+id);
	}



}