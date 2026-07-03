package com.cts.student.repository;

import com.cts.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    Page<Student> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);
    Page<Student> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
    Page<Student> findByCourseCode(String courseCode, Pageable pageable);
}
