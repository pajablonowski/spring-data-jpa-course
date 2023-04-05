package com.amigos.controllers;

import com.amigos.model.Student;
import com.amigos.repositories.StudentRepository;
import com.amigos.services.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/app/v1")
public class StudentController {


    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/1")
    public Student findStudentsByEmail() {
        Optional<Student> student = studentService.findByEmail("aliva.shtisel@gmail.com");
        if (student.isEmpty()){
            throw new NoSuchElementException();
        }
        return student.get();
    }
    @GetMapping("/2")
    public List<Student> findStudentsByFirstNameAndAge() {
        return studentService.findStudent("Paul", 42);
    }

}
