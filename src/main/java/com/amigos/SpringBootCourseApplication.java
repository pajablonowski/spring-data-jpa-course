package com.amigos;

import com.amigos.model.Student;
import com.amigos.model.StudentIdCard;
import com.amigos.repositories.StudentIdCardRepository;
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

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootCourseApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootCourseApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository) {
        return args -> {
            generateStudentIdCard(studentRepository,studentIdCardRepository);
            studentIdCardRepository.deleteById(1L);
        };
    }

    private List<Student> generateRandomStudents() {
        List<Student> studentList = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s.gmail.com", firstName.toLowerCase(), lastName.toLowerCase());
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            studentList.add(student);
        }
        return studentList;
    }

    private void generateStudentIdCard(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository) {
        List<Student> studentList = generateRandomStudents();
        int counter = 0;
        for (Student student : studentList) {
            studentRepository.save(student);
            StudentIdCard studentIdCard = new StudentIdCard(student, "CardId" + 100 + counter);
            studentIdCardRepository.save(studentIdCard);
            counter++;
        }

    }
}
