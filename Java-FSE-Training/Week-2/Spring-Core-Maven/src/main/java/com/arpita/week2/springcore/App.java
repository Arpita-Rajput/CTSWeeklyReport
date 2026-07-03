package com.arpita.week2.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.arpita.week2.springcore.config.AppConfig;
import com.arpita.week2.springcore.service.EmployeeService;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.displayEmployeeInfo();

        ((AnnotationConfigApplicationContext) context).close();
    }
}
