package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
    	System.out.println("INSIDE THE CONTROLLER");
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{rollno}")
    @Operation(description = "THIS IS RETRIEVING THE STUDENT DETAILS BASED ON ROLLNO PROVIDED")
    @ApiResponse(responseCode = "200", description = "THIS IS SUCCESSFUL RESPONSE")
    @ApiResponse(responseCode = "400", description = "THIS RESPONSE INDICATES SOME WRONG INPUT BEING PROVIDED")
    public ResponseEntity<Object> getStudentByRollno(@PathVariable("rollno") int rollno){
        System.out.println("INSIDE THE CONTROLLER - input: "+rollno);
        Student student = studentService.getStudentByRollno(rollno);
        if(student.getRollno() == 0){
            log.error("STUDENT DOESN'T EXIST");
            return new ResponseEntity<>("STUDENT DOESN'T EXIST", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        if(student.getRollno() <= 0)
            return new ResponseEntity<>("ROLLNO IS INVALID/MISSING - PLEASE CHECK AND ADD AGAIN", HttpStatus.BAD_REQUEST);
        try {
            studentService.upsertStudent(student);
            return new ResponseEntity<>("STUDENT ADDED SUCCESSFULLY", HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("EXCEPTION OCCURED WHILE EXECUTING DB OPERATION, PLEASE CHECK WITH ADMINISTRATOR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
}
