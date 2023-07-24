package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {
	
	public double divide(double first, double second) {
		System.out.println("THIS IS INSIDE THE SERVICE");
		return first/second;
	}
	

}
