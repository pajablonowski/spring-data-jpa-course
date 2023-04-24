package com.amigos.model.dto;

import java.time.LocalDateTime;

public class BookDTO {

    private Long id;
    private String bookName;
    private LocalDateTime createdAt;

    public BookDTO(Long id, String bookName, LocalDateTime createdAt) {
        this.id = id;
        this.bookName = bookName;
        this.createdAt = createdAt;
    }

    public BookDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
