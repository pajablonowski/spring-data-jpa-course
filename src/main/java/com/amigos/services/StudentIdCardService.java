package com.amigos.services;

import com.amigos.model.StudentIdCard;
import com.amigos.repositories.StudentIdCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentIdCardService {

    StudentIdCardRepository studentIdCardRepository;

    StudentIdCardService(StudentIdCardRepository studentIdCardRepository){
        this.studentIdCardRepository = studentIdCardRepository;
    }

    public List<StudentIdCard> findAllStudentIdCard(){
        return studentIdCardRepository.findAll();
    }

}
