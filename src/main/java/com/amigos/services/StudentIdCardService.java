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
        return DTOService.mapStudentIdCardListIntoStudentIdCardDTOList(studentIdCardRepository.findAll());
    }

    public List<StudentIdCardDTO> findAllStudentsIdCardByCardNumber(String cardNumber){
        return DTOService.mapStudentIdCardListIntoStudentIdCardDTOList(studentIdCardRepository.findAllStudentsIdCardByCardNumber(cardNumber));
    }

}
