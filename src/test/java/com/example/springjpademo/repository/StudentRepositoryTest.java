package com.example.springjpademo.repository;

import com.example.springjpademo.entity.Guardian;
import com.example.springjpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("dmnghia1511@gmail.com")
                .firstName("Do Minh")
                .lastName("Nghia")
//                .guardianName("Nikhil")
//                .guardianMobile("9999999999")
//                .guardianEmail("nihkil@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .email("nihkil@gmail.com")
                .mobile("999995417")
                .build();

        Student student = Student.builder()
                .firstName("Nguyen Tien")
                .lastName("Dat")
                .emailId("datnt@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        System.out.println("Result: " + studentRepository.findByFirstName("Do "));
    }

    @Test
    public void printStudentByFirstNameContaining() {
        System.out.println("Result: " + studentRepository.findByFirstNameContaining("n"));
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("student list: " + studentList);
    }
}