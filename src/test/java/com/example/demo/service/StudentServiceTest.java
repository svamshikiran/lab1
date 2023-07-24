package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class StudentServiceTest {
	
	private static List<Student> studentList;
	
	private static Student student;
	
	@InjectMocks
	StudentService studentService;
	
	@Mock
	StudentRepository stuRepo;

	@BeforeEach
	void setUp() throws Exception {
		
		 student = new Student();
		 student.setRollno(1);
		 student.setName("TESTNAME");
		 student.setCity("TESTCITY");
		 
		 studentList = Collections.singletonList(student);
		
	}

	@Test
	void testGetAllStudents() {
		//Mocking scenario
		when(stuRepo.findAll()).thenReturn(studentList);
		
		List<Student> actualStudentList = studentService.getAllStudents();
		
		assertNotNull(actualStudentList);
		assertEquals(studentList.size(), actualStudentList.size());
		assertEquals(studentList.get(0).getRollno(), actualStudentList.get(0).getRollno());
	}

}
