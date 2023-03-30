package com.amigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootCourseApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootCourseApplication.class, args);
	}

	@GetMapping("/start")
	public String start(){
		return "Start";
	}

}
