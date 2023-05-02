package com.amigos.repositories;


import com.amigos.model.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentIdCardRepository
        extends JpaRepository<StudentIdCard, Long> {

    @Query("SELECT s FROM StudentIdCard s where s.cardNumber like ?1")
    List<StudentIdCard> findAllStudentsIdCardByCardNumber(String cardNumber);

}
