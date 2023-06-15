package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.findStudentByEmail(student.getEmail())
            .ifPresentOrElse(s -> {
                System.out.println(student + " already exists.");
            }, () -> {
                System.out.println("Inserting student " + student);
                studentRepository.insert(student);
        });
    }

    public void deleteStudent(Student student) {
        studentRepository.findStudentByEmail(student.getEmail())
            .ifPresentOrElse(s -> {
                System.out.println("Deleting student " + student);
                studentRepository.delete(student);
            }, () -> {
                System.out.println(student + " does not exist.");
        });
    }

    public void updateStudent(Student student) {
        studentRepository.findStudentByEmail(student.getEmail())
            .ifPresentOrElse(s -> {
                System.out.println("Updating student " + student);
                studentRepository.save(student);
            }, () -> {
                System.out.println(student + " does not exist.");
        });
    }
}
