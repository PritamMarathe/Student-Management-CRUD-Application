package com.StudManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementCrudApplication.class, args);
		System.out.println("Welcome to Stud Application...");
	}

}
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>