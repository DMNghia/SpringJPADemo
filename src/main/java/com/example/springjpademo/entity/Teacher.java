package com.example.springjpademo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "courses")
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String fullName;
    private String teacherPhoneNumber;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Course> courses;
}
