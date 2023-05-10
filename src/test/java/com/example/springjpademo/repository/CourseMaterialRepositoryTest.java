package com.example.springjpademo.repository;

import com.example.springjpademo.entity.Course;
import com.example.springjpademo.entity.CourseMaterial;
import com.example.springjpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Spring")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("wwww.dailycodebuffer.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void findAllCourseMaterials() {
        List<CourseMaterial> list = courseMaterialRepository.findAll();
        System.out.println("All course material: " + list);
    }

    // Still error
    @Test
    public void saveCourseMaterialWithCourse() {

        Optional<Course> courseOptional = courseRepository.findById(3L);

        if (courseOptional.isPresent()) {
            CourseMaterial courseMaterial = CourseMaterial.builder()
                    .url("www.dailycodebuffer.com")
                    .course((Course) courseOptional.get())
                    .build();

            courseMaterialRepository.save(courseMaterial);
        } else {
            System.out.println("error");
        }

    }
}