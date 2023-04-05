package com.amigos.controllers;

import com.amigos.model.Student;
import com.amigos.repositories.StudentRepository;
import com.amigos.services.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/v1")
public class StudentController {


    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/start")
    public List<Student> start() {
        return studentService.getAllStudents();
    }

}
