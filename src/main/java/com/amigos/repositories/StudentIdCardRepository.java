package com.amigos.repositories;


import com.amigos.model.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository
        extends JpaRepository<StudentIdCard, Long> {
}
