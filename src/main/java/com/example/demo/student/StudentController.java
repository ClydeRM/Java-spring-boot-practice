package com.example.demo.student;

import com.example.demo.student.DTO.PatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "api/v1/student/")
public class StudentController {

    private final StudentService studentService;

    @Autowired() // Use Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return this.studentService.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PatchMapping(path = "{studentId}")
    public void updateStudentById(
            @PathVariable("studentId") Long studentId,
            @RequestBody(required = false) PatchDto body) {
//        System.out.println(body.getClass());
//        System.out.println(body.getName());

        studentService.updateStudentById(studentId, body);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }
}
