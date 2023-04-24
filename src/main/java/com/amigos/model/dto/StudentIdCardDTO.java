package com.amigos.model.dto;

public class StudentIdCardDTO {

    private Long id;
    private String cardNumber;

    public StudentIdCardDTO(Long id, String cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public StudentIdCardDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
