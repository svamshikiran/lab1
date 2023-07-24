package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculateControllerTest {
	
	@Autowired
	CalculateController calculateController;

	@Test
	public void testDivide() {
		double first = 35;
		double second = 25;
		
		double expectedResult = first/second;
		
		ResponseEntity<Object> responseEntity = calculateController.divideNew(first, second);
		
		assertNotNull(responseEntity);
		assertEquals(200, responseEntity.getStatusCodeValue());
		assertEquals(expectedResult, responseEntity.getBody());
	}
	
	@Test
	public void testDivideException() {
		double first = 35;
		double second = 0;
		
		ResponseEntity<Object> responseEntity = calculateController.divideNew(first, second);
		
		assertNotNull(responseEntity);
		assertEquals(400, responseEntity.getStatusCodeValue());
	}

}
