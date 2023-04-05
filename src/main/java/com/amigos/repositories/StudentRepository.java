package com.amigos.repositories;

import com.amigos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Long> {
}
