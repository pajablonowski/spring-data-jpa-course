package com.amigos.controllers;

import com.amigos.model.Student;
import com.amigos.model.dto.StudentDTO;
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
    public StudentDTO findStudentsByEmail() {
        Optional<StudentDTO> student = studentService.findByEmail("aliva.shtisel@gmail.com");
        if (student.isEmpty()){
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return student.get();
    }
    @GetMapping("/2")
    public List<StudentDTO> findStudentsByFirstNameAndAge() {
        return studentService.findStudent("Paul", 43);
    }

    @GetMapping("/3")
    public List<StudentDTO> findAllStudents() {
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return  allStudents;
    }

    @GetMapping("/4")
    public StudentDTO findStudentsByEmailJPQL() {
        Optional<StudentDTO> studentByEmailJPQL = studentService.findByEmailJPQL("mariagonzalez@gmail.com");

        if (studentByEmailJPQL.isEmpty()){
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return studentByEmailJPQL.get();
    }

    @GetMapping("/5")
    public List<StudentDTO> findStudentsByFirstNameAndAgeJPQL() {
        return studentService.findStudentJPQL("Paul", 43);
    }

    @GetMapping("/6")
    public StudentDTO findStudentsByEmailNativeQuerry() {
        Optional<StudentDTO> studentByEmailJPQL = studentService.findByEmailNativeQuerry("mariagonzalez@gmail.com");

        if (studentByEmailJPQL.isEmpty()){
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return studentByEmailJPQL.get();
    }

    @GetMapping("/7")
    public List<StudentDTO> findStudentsByFirstNameAndAgeNativeQuerry() {
        return studentService.findStudentNativeQuerry("Paul", 43);
    }

    @GetMapping("/8")
    public StudentDTO findStudentsByEmailNativeQuerryNamedParameter() {
        Optional<StudentDTO> studentByEmailJPQL = studentService.findByEmailNativeQuerryNamerParameter("mariagonzalez@gmail.com");

        if (studentByEmailJPQL.isEmpty()){
            throw new NoSuchElementException("Student with given email does not exist");
        }
        return studentByEmailJPQL.get();
    }

    @GetMapping("/9")
    public List<StudentDTO> findStudentsByFirstNameAndAgeNativeQuerryNamedParameter() {
        return studentService.findStudentNativeQuerryNamerParameter("Paul", 43);
    }

    @GetMapping("/10")
    public List<StudentDTO> findAllStudentsAndSortByFirtsName() {
        return studentService.getAllStudentsAndSortByFirstName();
    }
    @GetMapping("/11")
    public List<StudentDTO> findAllStudentsAndSortByLastName() {
        return studentService.getAllStudentsAndSortByLastName();
    }

    @GetMapping("/12")
    public List<StudentDTO> getAllStudentsAndSortByLastNameAndFirstName() {
        return studentService.getAllStudentsAndSortByLastNameAndFirstName();
    }

    @GetMapping("/13")
    public List<StudentDTO> getAllStudentsPaginated() {
        return studentService.getAllStudentsPaginated();
    }
}
