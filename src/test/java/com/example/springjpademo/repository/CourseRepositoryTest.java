package com.example.springjpademo.repository;

import com.example.springjpademo.entity.Course;
import com.example.springjpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses: " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .fullName("James Webb")
                .teacherPhoneNumber("0903413844")
                .build();

        Course course = Course.builder()
                .title(".NET")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}