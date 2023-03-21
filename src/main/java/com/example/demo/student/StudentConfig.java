package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            // Create Mock Student
            Student John = new Student(
                    "John",
                    "john@mail.com",
                    LocalDate.of(2000, Month.OCTOBER, 30)
            );

            Student Alex = new Student(
                    "Alex",
                    "alex@mail.com",
                    LocalDate.of(2008, Month.JANUARY, 1)
            );
            // Call repository to save object
            // Hibernate was invoke when call saveAll()
            repository.saveAll(
                    List.of(John, Alex)
            );
        };
    }
}
