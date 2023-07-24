package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping("/greet")
	public String sayHello() {
		return "WELCOME TO SPRINGBOOT FRAMEWORK";
	}
	
	//URL - http://localhost:9004/dbbatch5/hello/greet/VAMSHI
	@GetMapping("/greet/{name}")
	public String sayHello(@PathVariable("name") String input) {
		return "HI "+input+", WELCOME TO SPRINGBOOT FRAMEWORK";
	}
	
	//URL - http://localhost:9004/dbbatch5/hello/greetWithParameter?name=VAMSHI
	@GetMapping("/greetWithParameter")
	public String sayHelloWithParameter(@RequestParam("name") String input) {
		return "HI "+input+", WELCOME TO SPRINGBOOT FRAMEWORK, WITH REQUEST PARAMETER";
	}

}

//@RestController
//@Controller
//@Service
//@Repository
//@Component
//@Bean