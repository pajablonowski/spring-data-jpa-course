package com.amigos.services;

import com.amigos.model.Student;
import com.amigos.model.dto.StudentDTO;
import com.amigos.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {

    StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudents() {
        return DTOService.mapStudentListIntoStudentDTOList(studentRepository.findAll());
    }


    public List<StudentDTO> getAllStudentsAndSortByFirstName() {
        return DTOService.mapStudentListIntoStudentDTOList(studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName")));
    }

    public List<StudentDTO> getAllStudentsAndSortByLastName() {
        return DTOService.mapStudentListIntoStudentDTOList(studentRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName")));
    }

    public List<StudentDTO> getAllStudentsAndSortByLastNameAndFirstName() {
        return DTOService.mapStudentListIntoStudentDTOList(studentRepository
                .findAll(Sort.by("lastName").ascending()
                        .and(Sort.by("firstName").ascending())));
    }

    public List<StudentDTO> getAllStudentsPaginated() {
        PageRequest pageRequest = PageRequest.of(
                0,
                5,
                Sort.by("firstName").ascending());
        Page<Student> page = studentRepository.findAll(pageRequest);
        return DTOService.mapStudentListIntoStudentDTOList(page.get().collect(Collectors.toList()));
    }


    public Optional<Student> findByEmail(String email) {
        DTOService.mapStudentListIntoStudentDTOList(studentRepository
                .findAll(Sort.by("lastName").ascending()
                        .and(Sort.by("firstName").ascending())));
        return studentRepository.findByEmail(email);
    }

    public List<StudentDTO> findStudent(String firstName, Integer age) {

        return DTOService.mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqual(firstName, age));
    }

    public Optional<StudentDTO> findByEmailJPQL(String email) {
        Optional<Student> student = studentRepository.findByEmailJPQL(email);
        if (student.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(DTOService.mapStudentIntoStudentDTO(student.get()));
    }

    public List<StudentDTO> findStudentJPQL(String firstName, Integer age) {
        return DTOService.mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualJPQL(firstName, age));
    }

    public Optional<StudentDTO> findByEmailNativeQuerry(String email) {
        Optional<Student> student = studentRepository.findByEmailNativeQuerry(email);
        if (student.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(DTOService.mapStudentIntoStudentDTO(student.get()));
    }

    public List<StudentDTO> findStudentNativeQuerry(String firstName, Integer age) {

        return DTOService.mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerry(firstName, age));
    }

    public Optional<StudentDTO> findByEmailNativeQuerryNamerParameter(String email) {
        Optional<Student> student = studentRepository.findByEmailNativeQuerryNamedParameter(email);
        if (student.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(DTOService.mapStudentIntoStudentDTO(student.get()));
    }

    public List<StudentDTO> findStudentNativeQuerryNamerParameter(String firstName, Integer age) {
        return DTOService.mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerryNamedParameter(firstName, age));

    }

    public int deleteStudent(Long id) {
        return studentRepository.deleteStudentById(id);
    }

}
