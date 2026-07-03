package com.arpita.week1.junitmockito.service;

import com.arpita.week1.junitmockito.model.Student;
import com.arpita.week1.junitmockito.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getStudentName(int id) {
        return repository.findById(id).map(Student::getName).orElse("Unknown");
    }
}
