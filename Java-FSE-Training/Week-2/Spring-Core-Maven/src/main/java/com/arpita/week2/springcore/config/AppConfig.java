package com.arpita.week2.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.arpita.week2.springcore.repository.EmployeeRepository;
import com.arpita.week2.springcore.repository.EmployeeRepositoryImpl;
import com.arpita.week2.springcore.service.EmployeeService;
import com.arpita.week2.springcore.service.EmployeeServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepositoryImpl();
    }

    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }
}
