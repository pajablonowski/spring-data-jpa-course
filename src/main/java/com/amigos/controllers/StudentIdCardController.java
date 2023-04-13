package com.amigos.controllers;

import com.amigos.model.StudentIdCard;
import com.amigos.services.StudentIdCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/v2")
public class StudentIdCardController {

    StudentIdCardService studentIdCardService;

    StudentIdCardController(final StudentIdCardService studentIdCardService){
        this.studentIdCardService = studentIdCardService;
    }

    @GetMapping("/1")
    public List<StudentIdCard> findAll(){
        return studentIdCardService.findAllStudentIdCard();
    }

}
