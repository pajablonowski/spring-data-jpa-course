package com.amigos.repositories;

import com.amigos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);


    List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThan (
            String firstName,
            Integer age);
}
