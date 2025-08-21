package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
        return runner -> {
            //createStudent(studentDAO);

            creteMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            //queryForStudents(studentDAO);

            //queryForStudentsByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            //deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students....");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Rows Deleted: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student with id:" + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: PRIMARY KEY
        int studentId = 1;
        System.out.println("Getting the student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Scooby"
        System.out.println("UPDATING Student --->");
        myStudent.setFirstName("John");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated Student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Scott");

        for(Student s : theStudents){
            System.out.println(s);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display the list of students
        for(Student s : theStudents){
            System.out.println(s);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating a new student to retrieve: ....");
        Student tempStudent = new Student("James", "Scott", "jscott@gmail.com");

        // save the student
        System.out.println("Saving the Student.....");
        studentDAO.save(tempStudent);

        // display id of the student
        int theId = tempStudent.getId();
        System.out.println("Saved Student id: Primary Key --> " + theId);

        //retrieve student based on the id: primary key
        System.out.println("Retrieving the student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display the student
        System.out.println("Found the Student: " + myStudent);

    }

    private void creteMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating new student objects --> 3 ..... ");
        Student tempStudent1 = new Student("John", "Doe", "jdoe@gmail.com");
        Student tempStudent2 = new Student("Jack", "Sailer", "jsail@gmail.com");
        Student tempStudent3 = new Student("Mary", "Banita", "mbanita@gmail.com");

        // saving the student objects:
        System.out.println("Saving the student objects..... ");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ..... ");
        Student tempStudent = new Student("Umar", "Salman", "usal@gmail.com");

        // save the student object
        System.out.println("Saving the student object..... ");
        studentDAO.save(tempStudent);

        // display the id generated
        System.out.println("Saved the student. Generated Id: " + tempStudent.getId());
    }

}
