package com.arpita.week2.springcore.service;

import java.util.List;
import com.arpita.week2.springcore.model.Employee;
import com.arpita.week2.springcore.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    // Constructor Injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("\n===== All Employees =====");
        List<Employee> employees = getAllEmployees();
        employees.forEach(emp -> System.out.println(emp));

        System.out.println("\n===== Employee by ID (1) =====");
        Employee emp = getEmployeeById(1);
        if (emp != null) {
            System.out.println(emp);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
}
