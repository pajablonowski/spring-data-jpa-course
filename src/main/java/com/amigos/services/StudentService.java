package com.amigos.services;

import com.amigos.model.Student;
import com.amigos.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public List<Student> findStudent(String firstName, Integer age){
        return studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThan(firstName, age);
    }

}
