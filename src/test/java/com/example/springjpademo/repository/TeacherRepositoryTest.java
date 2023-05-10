package com.example.springjpademo.repository;

import com.example.springjpademo.entity.Course;
import com.example.springjpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .fullName("Quang")
                .teacherPhoneNumber("12983123")
//                .courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}