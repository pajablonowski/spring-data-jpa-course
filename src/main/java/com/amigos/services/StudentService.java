package com.amigos.services;

import com.amigos.model.Student;
import com.amigos.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Student> getAllStudentsAndSortByFirstName() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }

    public List<Student> getAllStudentsAndSortByLastName() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    public List<Student> getAllStudentsAndSortByLastNameAndFirstName() {
        return studentRepository
                .findAll(Sort.by("lastName").ascending()
                        .and(Sort.by("firstName").ascending()));
    }

    public Page<Student> getAllStudentsPaginated(){
        PageRequest pageRequest = PageRequest.of(
                0,
                5,
                Sort.by("firstName").ascending());
        Page<Student> page = studentRepository.findAll(pageRequest);
        return page;
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
