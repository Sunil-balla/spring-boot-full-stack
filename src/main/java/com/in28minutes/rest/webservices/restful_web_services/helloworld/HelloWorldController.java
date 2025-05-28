package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//int[] arr = {1, 2, 3}
	
@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello";
	}	
	
@GetMapping("/hello-world/bean")
public HelloWorldBean helloWorldBean() {
	return new HelloWorldBean("Hello");
}

@GetMapping("/hello-world/path-variable/{name}")
public HelloWorldBean helloWorldPathBean(@PathVariable String name) {
	//String message = "Hello " + name;
	return new HelloWorldBean(String.format("Hello %s", name));
}

}
