package com.amigos.services;

import com.amigos.model.Student;
import com.amigos.model.dto.BookDTO;
import com.amigos.model.dto.CourseEnrolmentDTO;
import com.amigos.model.dto.StudentDTO;
import com.amigos.model.dto.StudentIdCardDTO;
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

        return mapStudentListIntoStudentDTOList(studentRepository.findAll());

    }


    public List<StudentDTO> getAllStudentsAndSortByFirstName() {

        return mapStudentListIntoStudentDTOList(studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName")));
    }

    public List<StudentDTO> getAllStudentsAndSortByLastName() {

        return mapStudentListIntoStudentDTOList(studentRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName")));

    }

    public List<StudentDTO> getAllStudentsAndSortByLastNameAndFirstName() {

        return mapStudentListIntoStudentDTOList(studentRepository
                .findAll(Sort.by("lastName").ascending()
                        .and(Sort.by("firstName").ascending())));
    }

    public List<StudentDTO> getAllStudentsPaginated() {
        PageRequest pageRequest = PageRequest.of(
                0,
                5,
                Sort.by("firstName").ascending());
        Page<Student> page = studentRepository.findAll(pageRequest);

        return mapStudentListIntoStudentDTOList(page.get().collect(Collectors.toList()));
    }


    public Optional<StudentDTO> findByEmail(String email) {
        Optional<Student> studentByEmail = studentRepository.findByEmail(email);
        if (studentByEmail.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapStudentIntoStudentDTO(studentByEmail.get()));
    }

    public List<StudentDTO> findStudent(String firstName, Integer age) {

       return mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqual(firstName, age));
    }

    public Optional<StudentDTO> findByEmailJPQL(String email) {
        Optional<Student> student = studentRepository.findByEmailJPQL(email);
        if (student.isEmpty()) {
            return Optional.empty();
        }


        return Optional.of(mapStudentIntoStudentDTO(student.get()));
    }

    public List<StudentDTO> findStudentJPQL(String firstName, Integer age) {
        return mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualJPQL(firstName, age));
    }

    public Optional<StudentDTO> findByEmailNativeQuerry(String email) {
        Optional<Student> student = studentRepository.findByEmailNativeQuerry(email);
        if (student.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapStudentIntoStudentDTO(student.get()));
    }

    public List<StudentDTO> findStudentNativeQuerry(String firstName, Integer age) {

        return mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerry(firstName, age));
    }

    public Optional<StudentDTO> findByEmailNativeQuerryNamerParameter(String email) {
        Optional<Student> student = studentRepository.findByEmailNativeQuerryNamedParameter(email);
        if (student.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapStudentIntoStudentDTO(student.get()));
    }

    public List<StudentDTO> findStudentNativeQuerryNamerParameter(String firstName, Integer age) {
        return mapStudentListIntoStudentDTOList(studentRepository.findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerryNamedParameter(firstName, age));

    }

    public int deleteStudent(Long id) {
        return studentRepository.deleteStudentById(id);
    }

    private StudentDTO mapStudentIntoStudentDTO(Student student){
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                new StudentIdCardDTO(
                        student.getStudentIdCard().getId(),
                        student.getStudentIdCard().getCardNumber()),
                student.getBooks()
                        .stream()
                        .map(book -> new BookDTO(
                                book.getId(),
                                book.getBookName(),
                                book.getCreatedAt())).toList(),
                student.getEnrolments()
                        .stream()
                        .map(enrolment -> new CourseEnrolmentDTO(
                                enrolment.getCourse().getId(),
                                enrolment.getCourse().getName(),
                                enrolment.getCourse().getDepartment(),
                                enrolment.getCreatedAt()
                        )).toList()
        );
    }
    private List<StudentDTO> mapStudentListIntoStudentDTOList(List<Student> studentList){
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.forEach(student -> studentDTOList.add(mapStudentIntoStudentDTO(student)));
        return studentDTOList;
    }
}
