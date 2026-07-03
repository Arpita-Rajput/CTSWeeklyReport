CREATE DATABASE IF NOT EXISTS employee_db;

USE employee_db;

CREATE TABLE IF NOT EXISTS employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL,
    date_of_joining DATE NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO employees (first_name, last_name, email, phone_number, department, salary, date_of_joining, is_active)
VALUES 
('John', 'Doe', 'john.doe@company.com', '9876543210', 'Engineering', 75000, '2023-01-15', TRUE),
('Jane', 'Smith', 'jane.smith@company.com', '9876543211', 'HR', 60000, '2023-02-20', TRUE),
('Mike', 'Johnson', 'mike.johnson@company.com', '9876543212', 'Sales', 70000, '2023-03-10', TRUE);
