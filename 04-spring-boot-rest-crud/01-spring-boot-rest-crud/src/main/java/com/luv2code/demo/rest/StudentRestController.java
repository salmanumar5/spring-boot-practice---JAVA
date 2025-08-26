package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> studentList;

    @PostConstruct
    public void loadData(){

        studentList = new ArrayList<>();

        studentList.add(new Student("Umar", "Salman"));
        studentList.add(new Student("John", "Done"));
        studentList.add(new Student("Smith", "Mike"));
    }

    // define an endpoint for "/student" - return a list of Students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return studentList;
    }

    // define endpoint for "/student/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list and return the student with index studentId -- just simple for now

        // check the student id against the list size
        if(studentId >= studentList.size() || studentId < 0){
            throw new StudentNotFoundException("Student not found: Id out of bound - " + studentId);
        }
        return studentList.get(studentId);
    }

}
