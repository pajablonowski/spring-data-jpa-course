package com.amigos;

import com.amigos.model.Student;
import com.amigos.repositories.StudentRepository;
import com.amigos.services.StudentService;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
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
            generateRandomStudents(studentRepository);
        };
    }

    private void generateRandomStudents(StudentRepository studentRepository){
        Faker faker = new Faker();
        for (int i = 0; i<20; i++){
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s.gmail.com",firstName.toLowerCase(), lastName.toLowerCase());
//                new StringBuilder()
//                        .append(firstName.toLowerCase())
//                        .append(".")
//                        .append(lastName.toLowerCase())
//                        .append("@gmail.com").toString();
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17,55));
            studentRepository.save(student);
        }
    }
}
