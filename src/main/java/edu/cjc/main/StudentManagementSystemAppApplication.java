package edu.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemAppApplication {

	public static void main(String[] args) {
		System.out.println("Student Management System");
	 	SpringApplication.run(StudentManagementSystemAppApplication.class, args);
	}
}
