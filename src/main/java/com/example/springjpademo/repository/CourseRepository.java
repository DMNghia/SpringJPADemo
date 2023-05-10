package com.example.springjpademo.repository;

import com.example.springjpademo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public Course findCourseByCourseId(Long courseId);
}
