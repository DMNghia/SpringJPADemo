package com.example.springjpademo.repository;

import com.example.springjpademo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    //JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId like %:emailAddress%")
    Student findByEmailAddressContaining(String emailAddress);

    //Native query
    @Query(
            value = "SELECT * FROM Student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student findByEmailAddressNative(String emailAddress);

    //Native query named param
    @Query(
            value = "SELECT * FROM Student s WHERE s.email_address = :emailAddress",
            nativeQuery = true
    )
    Student findByEmailAddressNativeNamedParam(@Param("emailAddress") String emailAddress);

    //Modify and transactional annotation
    @Modifying
    @Transactional
    @Query(
            value = "update student s set s.first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    void updateStudentFirstNameByEmailId(String firstName, String emailAddress);
}
