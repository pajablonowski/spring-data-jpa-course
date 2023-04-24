package com.amigos.model.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private StudentIdCardDTO studentIdCard;

    private List<BookDTO> books = new ArrayList<>();

    private List<CourseEnrolmentDTO> courseEnrolments = new ArrayList<>();


    public StudentDTO(
            Long id,
            String firstName,
            String lastName,
            String email,
            Integer age,
            StudentIdCardDTO studentIdCard,
            List<BookDTO> books,
            List<CourseEnrolmentDTO> courseEnrolments
            ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.studentIdCard = studentIdCard;
        this.books = books;
        this.courseEnrolments = courseEnrolments;
    }

    public StudentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public StudentIdCardDTO getStudentIdCard() {
        return studentIdCard;
    }

    public void setStudentIdCard(StudentIdCardDTO studentIdCard) {
        this.studentIdCard = studentIdCard;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public List<CourseEnrolmentDTO> getCourseEnrolments() {
        return courseEnrolments;
    }

    public void setCourseEnrolments(List<CourseEnrolmentDTO> courseEnrolments) {
        this.courseEnrolments = courseEnrolments;
    }
}
