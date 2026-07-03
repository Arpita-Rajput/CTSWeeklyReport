package com.arpita.week2.springcore.repository;

import java.util.ArrayList;
import java.util.List;
import com.arpita.week2.springcore.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoryImpl() {
        this.employees.add(new Employee(1, "Arpita Rajput", "Development", 75000));
        this.employees.add(new Employee(2, "Rajesh Kumar", "QA", 65000));
        this.employees.add(new Employee(3, "Priya Singh", "DevOps", 85000));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }
}
