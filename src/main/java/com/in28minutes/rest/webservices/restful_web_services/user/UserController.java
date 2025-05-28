package com.in28minutes.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	private UserDaoService service;
	
	/*UserController() {
		super();
	}*/

	public UserController(UserDaoService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveOne(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null)
			throw new UserNotFoundException("User " + id + " not found / invalid user");
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	/*@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		service.save(user);
	}*/
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.delete(id);
	}
	
	@DeleteMapping("/users/deleteAll")
	public void deleteAll() {
		service.deleteAll();
	}
	
	
	
}
