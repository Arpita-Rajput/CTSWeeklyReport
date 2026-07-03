CREATE DATABASE IF NOT EXISTS student_db;

USE student_db;

CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    course_code VARCHAR(50) NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    enrollment_date DATE NOT NULL,
    gpa DOUBLE,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO students (first_name, last_name, email, phone_number, course_code, course_name, enrollment_date, gpa, is_active)
VALUES 
('Alice', 'Brown', 'alice.brown@university.com', '9876543220', 'CS101', 'Data Structures', '2024-01-15', 3.8, TRUE),
('Bob', 'White', 'bob.white@university.com', '9876543221', 'CS101', 'Data Structures', '2024-01-15', 3.5, TRUE),
('Carol', 'Green', 'carol.green@university.com', '9876543222', 'CS201', 'Database Systems', '2024-01-15', 3.9, TRUE);
