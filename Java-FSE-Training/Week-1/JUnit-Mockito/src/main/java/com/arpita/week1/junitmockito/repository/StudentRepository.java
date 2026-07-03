package com.arpita.week1.junitmockito.repository;

import com.arpita.week1.junitmockito.model.Student;

import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(int id);
}
