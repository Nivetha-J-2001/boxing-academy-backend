package com.springboot.demo;

import com.springboot.demo.model.Student;
import com.springboot.demo.model.ModelStudentTableView.StudentTableView;
import com.springboot.demo.config.SpringConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

}
