package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/students") //link: http://localhost:8080/api/v1/students
@AllArgsConstructor
public class StudentController {
    
    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void insertStudent(Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(Student student) {
        studentService.deleteStudent(student);
    }

    @PutMapping
    public void updateStudent(Student student) {
        studentService.updateStudent(student);
    }
}
