package com.nikola.student;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			// String email, LocalDate dateOfBirth, Integer age
			Student nikola =new Student("Nikola","nikolajanev57@yahoo.com",LocalDate.of(2000, Month.DECEMBER, 21));
			studentRepository.save(nikola);
		};
	}

}
