package com.arpita.week2.springdatajpa.service;

import java.util.List;
import com.arpita.week2.springdatajpa.dto.StudentDTO;
import com.arpita.week2.springdatajpa.model.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(StudentDTO studentDTO);
    Student updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}
