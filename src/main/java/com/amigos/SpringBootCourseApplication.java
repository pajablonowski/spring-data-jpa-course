package com.amigos;

import com.amigos.model.Book;
import com.amigos.model.Student;
import com.amigos.model.StudentIdCard;
import com.amigos.repositories.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootCourseApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootCourseApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            generateRandomStudents(studentRepository);
//            studentIdCardRepository.deleteById(1L);


        };
    }

    void generateRandomStudents(StudentRepository studentRepository) {
        Faker faker = new Faker();
        List<Student> studentL = new ArrayList<>();
        for (int x = 0; x < 10; x++) {
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

            StudentIdCard studentIdCard = new StudentIdCard(
                    "IdCard" + x,
                    student);

            student.setStudentIdCard(studentIdCard);

            studentRepository.save(student);
            studentL.add(student);
        }



        studentRepository.findStudentById(1L).ifPresent(s -> {
            System.out.println("fetch book lazy...");
            List<Book> books = s.getBooks();
            books.forEach(book -> {
                System.out.println(
                        s.getFirstName() + " borrowed " + book.getBookName());
            });
        });
    }
}
