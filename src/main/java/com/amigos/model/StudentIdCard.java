package com.amigos.model;

import jakarta.persistence.*;

@Entity(name = "StudentIdCart")
@Table(
        name = "student_id_card",
        uniqueConstraints = {
                @UniqueConstraint(name="student_id_card_number_unique",columnNames = "card_number")}
)
public class StudentIdCard {

    @Id
    @SequenceGenerator(
            name = "student_id_card_sequence",
            sequenceName = "student_id_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_card_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            nullable = false,
            columnDefinition = "TEXT",
            length = 15
    )
    private String cardNumer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
    )
    private Student student;

    public StudentIdCard() {
    }

    public StudentIdCard(Student student , String cardNumer) {
        this.student = student;
        this.cardNumer = cardNumer;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumer() {
        return cardNumer;
    }

    public void setCardNumer(String cardNumer) {
        this.cardNumer = cardNumer;
    }
}
