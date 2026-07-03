# Spring Data JPA - Student CRUD

REST API for Student management with Spring Data JPA, Validation, and Exception Handling.

Requirements:
- Java 21
- Spring Boot 3
- MySQL

Setup MySQL:
CREATE DATABASE student_db;

Run:
mvn clean spring-boot:run

APIs:
GET    /api/students
GET    /api/students/{id}
POST   /api/students
PUT    /api/students/{id}
DELETE /api/students/{id}
