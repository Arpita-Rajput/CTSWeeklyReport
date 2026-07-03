package com.arpita.week2.springcore.service;

import java.util.List;
import com.arpita.week2.springcore.model.Employee;

public interface EmployeeService {
    void displayEmployeeInfo();
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
}
