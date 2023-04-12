package com.amigos.controllers;

import com.amigos.model.Student;
import com.amigos.repositories.StudentRepository;
import com.amigos.services.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
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
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return student.get();
    }
    @GetMapping("/2")
    public List<Student> findStudentsByFirstNameAndAge() {
        return studentService.findStudent("Paul", 43);
    }

    @GetMapping("/3")
    public List<Student> findAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/4")
    public Student findStudentsByEmailJPQL() {
        Optional<Student> studentByEmailJPQL = studentService.findByEmailJPQL("mariagonzalez@gmail.com");

        if (studentByEmailJPQL.isEmpty()){
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return studentByEmailJPQL.get();
    }

    @GetMapping("/5")
    public List<Student> findStudentsByFirstNameAndAgeJPQL() {
        return studentService.findStudentJPQL("Paul", 43);
    }

    @GetMapping("/6")
    public Student findStudentsByEmailNativeQuerry() {
        Optional<Student> studentByEmailJPQL = studentService.findByEmailNativeQuerry("mariagonzalez@gmail.com");

        if (studentByEmailJPQL.isEmpty()){
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return studentByEmailJPQL.get();
    }

    @GetMapping("/7")
    public List<Student> findStudentsByFirstNameAndAgeNativeQuerry() {
        return studentService.findStudentNativeQuerry("Paul", 43);
    }

    @GetMapping("/8")
    public Student findStudentsByEmailNativeQuerryNamedParameter() {
        Optional<Student> studentByEmailJPQL = studentService.findByEmailNativeQuerryNamerParameter("mariagonzalez@gmail.com");

        if (studentByEmailJPQL.isEmpty()){
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return studentByEmailJPQL.get();
    }

    @GetMapping("/9")
    public List<Student> findStudentsByFirstNameAndAgeNativeQuerryNamedParameter() {
        return studentService.findStudentNativeQuerryNamerParameter("Paul", 43);
    }

    @GetMapping("/10")
    public List<Student> findAllStudentsAndSortByFirtsName() {
        return studentService.getAllStudentsAndSortByFirstName();
    }
    @GetMapping("/11")
    public List<Student> findAllStudentsAndSortByLastName() {
        return studentService.getAllStudentsAndSortByLastName();
    }

    @GetMapping("/12")
    public List<Student> getAllStudentsAndSortByLastNameAndFirstName() {
        return studentService.getAllStudentsAndSortByLastNameAndFirstName();
    }

    @GetMapping("/13")
    public Page<Student> getAllStudentsPaginated() {
        return studentService.getAllStudentsPaginated();
    }
}
