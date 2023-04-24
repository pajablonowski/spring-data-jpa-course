package com.amigos.services;

import com.amigos.model.Book;
import com.amigos.model.Enrolment;
import com.amigos.model.Student;
import com.amigos.model.StudentIdCard;
import com.amigos.model.dto.BookDTO;
import com.amigos.model.dto.CourseEnrolmentDTO;
import com.amigos.model.dto.StudentDTO;
import com.amigos.model.dto.StudentIdCardDTO;

import java.util.ArrayList;
import java.util.List;

public class DTOService {

    public static StudentDTO mapStudentIntoStudentDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                mapStudentIdCardIntoStudentIdCardDTO(student.getStudentIdCard()),
                mapBookListIntoBookDTOList(student.getBooks()),
                mapEnrolmentsListIntoCourseEnrolmentDTOList(student.getEnrolments()));
    }

    public static List<StudentDTO> mapStudentListIntoStudentDTOList(List<Student> studentList) {
        List<StudentDTO> listOfStudents = new ArrayList<>();
        studentList.forEach(student -> listOfStudents.add(
                new StudentDTO(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.getAge(),
                        mapStudentIdCardIntoStudentIdCardDTO(student.getStudentIdCard()),
                        mapBookListIntoBookDTOList(student.getBooks()),
                        mapEnrolmentsListIntoCourseEnrolmentDTOList(student.getEnrolments())
                )));

        return listOfStudents;
    }

    public static List<StudentIdCardDTO> mapStudentIdCardListIntoStudentIdCardDTOList(List<StudentIdCard> studentIdCardList) {
        List<StudentIdCardDTO> studentIdCardDTO = new ArrayList<>();

        studentIdCardList.forEach(studentIdCard ->
                studentIdCardDTO.add(
                        new StudentIdCardDTO(studentIdCard.getId(), studentIdCard.getCardNumber())
                )
        );
        return studentIdCardDTO;
    }

    public static StudentIdCardDTO mapStudentIdCardIntoStudentIdCardDTO(StudentIdCard studentIdCard) {
        return new StudentIdCardDTO(studentIdCard.getId(), studentIdCard.getCardNumber());
    }

    public static List<BookDTO> mapBookListIntoBookDTOList(List<Book> booksList) {
        List<BookDTO> bookList = new ArrayList<>();

        booksList.forEach(book -> bookList.add(
                new BookDTO(book.getId(), book.getBookName(), book.getCreatedAt())
        ));
        return bookList;
    }

    public static List<CourseEnrolmentDTO> mapEnrolmentsListIntoCourseEnrolmentDTOList(List<Enrolment> enrolments) {
        List<CourseEnrolmentDTO> enrolemntsList = new ArrayList<>();

        enrolments.forEach(enrolment -> enrolemntsList.add(
                new CourseEnrolmentDTO(
                        enrolment.getCourse().getId(),
                        enrolment.getCourse().getName(),
                        enrolment.getCourse().getDepartment(),
                        enrolment.getCreatedAt())
        ));

        return enrolemntsList;
    }

}
