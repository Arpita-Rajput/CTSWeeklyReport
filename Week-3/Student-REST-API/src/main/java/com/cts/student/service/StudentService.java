package com.cts.student.service;

import com.cts.student.dto.StudentDTO;
import com.cts.student.entity.Student;
import com.cts.student.exception.StudentNotFoundException;
import com.cts.student.exception.DuplicateEmailException;
import com.cts.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Page<StudentDTO> getAllStudents(Pageable pageable) {
        Page<Student> students = studentRepository.findAll(pageable);
        return students.map(this::convertToDTO);
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        return convertToDTO(student);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        if (studentRepository.findByEmail(studentDTO.getEmail()).isPresent()) {
            throw new DuplicateEmailException("Student with email " + studentDTO.getEmail() + " already exists");
        }
        Student student = convertToEntity(studentDTO);
        student.setIsActive(true);
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        if (!student.getEmail().equals(studentDTO.getEmail()) &&
                studentRepository.findByEmail(studentDTO.getEmail()).isPresent()) {
            throw new DuplicateEmailException("Email " + studentDTO.getEmail() + " is already in use");
        }

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setCourseCode(studentDTO.getCourseCode());
        student.setCourseName(studentDTO.getCourseName());
        student.setEnrollmentDate(studentDTO.getEnrollmentDate());
        student.setGpa(studentDTO.getGpa());
        student.setIsActive(studentDTO.getIsActive());

        Student updatedStudent = studentRepository.save(student);
        return convertToDTO(updatedStudent);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
    }

    public Page<StudentDTO> searchByFirstName(String firstName, Pageable pageable) {
        Page<Student> students = studentRepository.findByFirstNameContainingIgnoreCase(firstName, pageable);
        return students.map(this::convertToDTO);
    }

    public Page<StudentDTO> searchByLastName(String lastName, Pageable pageable) {
        Page<Student> students = studentRepository.findByLastNameContainingIgnoreCase(lastName, pageable);
        return students.map(this::convertToDTO);
    }

    public Page<StudentDTO> searchByCourseCode(String courseCode, Pageable pageable) {
        Page<Student> students = studentRepository.findByCourseCode(courseCode, pageable);
        return students.map(this::convertToDTO);
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setCourseCode(student.getCourseCode());
        dto.setCourseName(student.getCourseName());
        dto.setEnrollmentDate(student.getEnrollmentDate());
        dto.setGpa(student.getGpa());
        dto.setIsActive(student.getIsActive());
        return dto;
    }

    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setCourseCode(dto.getCourseCode());
        student.setCourseName(dto.getCourseName());
        student.setEnrollmentDate(dto.getEnrollmentDate());
        student.setGpa(dto.getGpa());
        return student;
    }
}
