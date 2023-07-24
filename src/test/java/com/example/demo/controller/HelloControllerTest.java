package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {
	
	@Autowired
	HelloController helloController;

	@Test
	public void testSayHello() {
		String expectedMessage = "WELCOME TO SPRINGBOOT FRAMEWORK";
		
		String actualMessage = helloController.sayHello();
		
		assertNotNull(actualMessage);		
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void testSayHelloWithParameters() {
		
		String actualMessage = helloController.sayHello("TEST");
		
		assertNotNull(actualMessage);		
		assertTrue(actualMessage.contains("TEST"));
	}
	
	@Test
	public void testSayHelloWithParameter() {
		
		String actualMessage = helloController.sayHelloWithParameter("TEST");
		
		assertNotNull(actualMessage);		
		assertTrue(actualMessage.contains("TEST"));
		assertTrue(actualMessage.contains("WITH REQUEST PARAMETER"));
	}

}
