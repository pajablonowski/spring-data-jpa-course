package com.amigos.model.dto;

import java.time.LocalDateTime;

public class CourseEnrolmentDTO {

    private Long courseId;
    private String name;
    private String department;
    private LocalDateTime createdAt;

    public CourseEnrolmentDTO(Long courseId, String name, String department, LocalDateTime createdAt) {
        this.courseId = courseId;
        this.name = name;
        this.department = department;
        this.createdAt = createdAt;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
