package com.amigos;

import com.amigos.model.*;
import com.amigos.repositories.BookRepository;
import com.amigos.repositories.StudentIdCardRepository;
import com.amigos.repositories.StudentRepository;
import com.github.javafaker.Faker;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class SpringBootCourseApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootCourseApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
                                    StudentRepository studentRepository,
                                    StudentIdCardRepository studentIdCardRepository,
                                    BookRepository bookRepository) {
        return args -> {
            generateRandomStudents(studentRepository);
     //       deleteingProblem(studentRepository, studentIdCardRepository);
            addingNewBook(studentRepository, bookRepository);


        };
    }

    void generateRandomStudents(StudentRepository studentRepository) {

        Faker faker = new Faker();
        List<Student> studentL = new ArrayList<>();


            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));

            student.addBook(
                    new Book("Clean Code", LocalDateTime.now().minusDays(4)));

            student.addBook(
                    new Book("Think and Grow Rich", LocalDateTime.now()));

            student.addBook(
                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));

            student.addEnrolment(
                    new Enrolment(
                            new EnrolmentId(1L, 1L),
                            student,
                            new Course(
                                    "Spring Data JPA",
                                    "IT"
                            ),
                            LocalDateTime.now()
                    )
            );

            student.addEnrolment(
                    new Enrolment(
                            new EnrolmentId(1L,2L),
                            student,
                            new Course(
                                    "Many to many relationships",
                                    "IT"),
                            LocalDateTime.now().minusDays(17)
                    )
            );

            StudentIdCard studentIdCard = new StudentIdCard(
                    "IdCard",
                    student);

            student.setStudentIdCard(studentIdCard);

            studentRepository.save(student);
            studentL.add(student);


        studentRepository.findStudentById(1L).ifPresent(s -> {
            System.out.println("fetch book lazy...");
            List<Book> books = s.getBooks();
            books.forEach(book -> {
                System.out.println(
                        s.getFirstName() + " borrowed " + book.getBookName());
            });
        });
    }

    private void deleteingProblem(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository){
 //               studentRepository.deleteStudentById(1L);
        //       studentIdCardRepository.deleteById(1L);
    }

    private void addingNewBook(StudentRepository studentRepository, BookRepository bookRepository){

//        //1
        Optional<Student> studentById = studentRepository.findStudentById(1L);
        Student student = studentById.get();
        student.addBook(new Book("Biblia", LocalDateTime.now()));
        studentRepository.save(student);

//        2
//        Student student1 = studentRepository.findStudentById(1L).get();
//        bookRepository.save(
//                new Book(
//                        "Biblia",
//                        LocalDateTime.now(),
//                        student1
//                        )
//
//        );

    }
}
