package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository stuRepo;


    public List<Student> getAllStudents(){
    	System.out.println("INSIDE THE SERVICE");
        return stuRepo.findAll();//select * from student;
    }

    public Student getStudentByRollno(int rollno){
        System.out.println("INSIDE THE SERVICE - input: "+rollno);
        Optional<Student> opStudentObj = stuRepo.findById(rollno);//select * from student where rollno=?
        if(opStudentObj.isPresent())
            return opStudentObj.get();
        else
            return new Student();
    }
    
    public void upsertStudent(Student student) {
    	stuRepo.save(student);
    	/*
        insert a record, if the record is not present in the table
        update the record, if it is present in the table
        */
    }

   
}
