package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CalculateService;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
	
	//Dependency Injection
	@Autowired
	CalculateService calculateService;
	
	@GetMapping("/divide/{first}/{second}")
	public double divide(@PathVariable("first") double firstNumber, 
			@PathVariable("second") double secondNumber) {
		return firstNumber/secondNumber;
	}
	
	@GetMapping("/divideNew")
	public ResponseEntity<Object> divideNew(@RequestParam("first") double firstNumber, 
			@RequestParam("second") double secondNumber) {
		System.out.println("THIS IS INSIDE THE CONTROLLER");
		if(secondNumber == 0) {
			return new ResponseEntity<>("INPUT HAS ZERO, PLEASE CHECK AND RETRY", HttpStatus.BAD_REQUEST);
		}
	
		return new ResponseEntity<>( calculateService.divide(firstNumber, secondNumber), HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/add")
	 * @GetMapping("/subtract")
	 * @GetMapping("/multiply")
	 * 
	 */

}
