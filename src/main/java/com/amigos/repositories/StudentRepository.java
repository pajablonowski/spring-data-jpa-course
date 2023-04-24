package com.amigos.repositories;

import com.amigos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("SELECT s FROM Student s where s.email = ?1")
    Optional<Student> findByEmailJPQL(String email);

    @Query("SELECT s FROM Student s JOIN FETCH s.books where s.id = ?1")
    Optional<Student> findStudentById(Long id);

    @Query("SELECT s FROM Student s JOIN FETCH s.books")
    List<Student> findAllStudents();

    @Query("SELECT s from Student s WHERE s.firstName =?1 AND s.age>=?2")
    List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualJPQL(
            String firstName,
            Integer age);

    @Query(
            value = "SELECT s.* FROM student s where s.email = ?1",
            nativeQuery = true)
    Optional<Student> findByEmailNativeQuerry(String email);

    @Query(
            value = "SELECT s.* from Student s WHERE s.first_name =?1 AND s.age>=?2",
            nativeQuery = true)
    List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerry(
            String firstName,
            Integer age);

    @Query(
            value = "SELECT s.* FROM student s where s.email = :email",
            nativeQuery = true)
    Optional<Student> findByEmailNativeQuerryNamedParameter(String email);

    @Query(
            value = "SELECT s.* from Student s WHERE s.first_name= :firstName AND s.age>= :age",
            nativeQuery = true)
    List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThanEqualNativeQuerryNamedParameter(
            @Param("firstName") String firstName,
            @Param("age") Integer age);

    Optional<Student> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.id =?1")
    int deleteStudentById(Long id);

    List<Student> findStudentByFirstNameEqualsAndAgeIsGreaterThanEqual(
            String firstName,
            Integer age);


}
