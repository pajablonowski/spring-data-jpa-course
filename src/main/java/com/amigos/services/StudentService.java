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
        return studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqual(firstName, age);
    }

    public Optional<Student> findByEmailJPQL(String email){
        return studentRepository.findByEmailJPQL(email);
    }

    public List<Student> findStudentJPQL(String firstName, Integer age){
        return studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualJPQL(firstName, age);
    }

    public Optional<Student> findByEmailNativeQuerry(String email){
        return studentRepository.findByEmailNativeQuerry(email);
    }

    public List<Student> findStudentNativeQuerry(String firstName, Integer age){
        return studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerry(firstName, age);
    }

    public Optional<Student> findByEmailNativeQuerryNamerParameter(String email){
        return studentRepository.findByEmailNativeQuerryNamedParameter(email);
    }

    public List<Student> findStudentNativeQuerryNamerParameter(String firstName, Integer age){
        return studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerryNamedParameter(firstName, age);
    }

    public int deleteStudent(Long id){
        return studentRepository.deleteStudentById(id);
    }

}
