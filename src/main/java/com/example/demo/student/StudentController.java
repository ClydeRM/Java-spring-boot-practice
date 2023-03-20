package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController()
@RequestMapping(path = "api/v1/student/")
public class StudentController {

    private final StudentService studentService;

    @Autowired() // Use Injection
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping(path = "/")
    public List<Student> getStudent() {
        return this.studentService.getStudent();
    }
}
