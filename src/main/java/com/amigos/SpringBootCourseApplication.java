package com.amigos;

import com.amigos.model.Student;
import com.amigos.repositories.StudentRepository;
import com.amigos.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
            Student maria = new Student(
                    "Maria",
                    "Gonzalez",
                    "mariagonzalez@gmail.com",
                    33);
            Student paul1 = new Student(
                    "Paul",
                    "Lopez",
                    "paulLopez@gmail.com",
                    45);
            Student paul2 = new Student(
                    "Paul",
                    "Llonck",
                    "paulllonck@gmail.com",
                    43);
            Student akiva = new Student(
                    "Akiva",
                    "Shtisel",
                    "aliva.shtisel@gmail.com",
                    31);
            studentRepository.saveAll(List.of(maria, paul1, akiva, paul2));
            System.out.println(studentRepository.count());
            studentRepository
                    .findById(4L)
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Student with ID 4 does not exist"));

        };


    }
}
