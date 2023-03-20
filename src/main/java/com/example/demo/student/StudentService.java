package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentService {

    public List<Student> getStudent() {
        return List.of(
                new Student(
                        1L,
                        "John",
                        "john@mail.com",
                        18,
                        LocalDate.of(2000, Month.OCTOBER, 30)
                )
        );
    }
}
