package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    // saving a student in the db : CREATE
    void save(Student theStudent);

    // retrieving the student by Id from the db : READ
    Student findById(Integer id);

    // retrieving the list of students using query : READ
    List<Student> findAll();

    // retrieving the list of students using query with parameter : READ
    List<Student> findByLastName(String theLastName);

    // updating the field of the student in the db : UPDATE
    void update(Student theStudent);

    // delete a student from the database : DELETE
    void delete(Integer id);

    // deleting all the students : DELETE
    int deleteAll();
}
