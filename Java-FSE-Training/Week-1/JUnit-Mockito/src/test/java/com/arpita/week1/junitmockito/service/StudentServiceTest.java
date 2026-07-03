package com.arpita.week1.junitmockito.service;

import com.arpita.week1.junitmockito.model.Student;
import com.arpita.week1.junitmockito.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class StudentServiceTest {
    private StudentRepository repository;
    private StudentService service;

    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(StudentRepository.class);
        service = new StudentServiceImpl(repository);
    }

    @Test
    public void whenStudentExists_thenReturnName() {
        when(repository.findById(1)).thenReturn(Optional.of(new Student(1, "Arpita")));
        String name = service.getStudentName(1);
        assertEquals("Arpita", name);
    }

    @Test
    public void whenStudentMissing_thenReturnUnknown() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        String name = service.getStudentName(999);
        assertEquals("Unknown", name);
    }
}
