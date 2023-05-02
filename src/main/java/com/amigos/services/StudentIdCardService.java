package com.amigos.services;

import com.amigos.model.StudentIdCard;
import com.amigos.model.dto.StudentIdCardDTO;
import com.amigos.repositories.StudentIdCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentIdCardService {

    StudentIdCardRepository studentIdCardRepository;

    StudentIdCardService(StudentIdCardRepository studentIdCardRepository) {
        this.studentIdCardRepository = studentIdCardRepository;
    }

    public List<StudentIdCardDTO> findAllStudentIdCard() {

        return studentIdCardRepository.findAll()
                .stream()
                .map(studentIdCard -> new StudentIdCardDTO(
                        studentIdCard.getId(),
                        studentIdCard.getCardNumber())).toList();

    }

    public List<StudentIdCardDTO> findAllStudentsIdCardByCardNumber(String cardNumber){

        return studentIdCardRepository.findAllStudentsIdCardByCardNumber(cardNumber)
                .stream()
                .map(studentIdCard -> new StudentIdCardDTO(
                        studentIdCard.getId(),
                        studentIdCard.getCardNumber())).toList();
    }

}
