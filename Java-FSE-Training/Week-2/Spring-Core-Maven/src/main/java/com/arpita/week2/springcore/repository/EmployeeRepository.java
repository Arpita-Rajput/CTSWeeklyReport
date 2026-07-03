package com.arpita.week2.springcore.repository;

import java.util.List;
import com.arpita.week2.springcore.model.Employee;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
}
