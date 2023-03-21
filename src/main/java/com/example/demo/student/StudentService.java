package com.example.demo.student;

import com.example.demo.student.DTO.PatchDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired()
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        //  System.out.println(student);
        // Find email
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        // Check email
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken.");
        }
        // Save new student
        studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("StudentId:" + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudentById(Long studentId, PatchDto body) {
        // Check Student exist
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "StudentId" + studentId + " does not exist."
                ));
        String name = body.getName();
        String email = body.getEmail();

        // validate name
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        // check email
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentEmail = studentRepository.findStudentByEmail(email);
            if (studentEmail.isPresent()){
                throw new IllegalStateException("Email taken.");
            }
            student.setEmail(email);
        }
    }
}
