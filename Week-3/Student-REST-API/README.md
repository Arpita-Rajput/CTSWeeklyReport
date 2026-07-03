# Student REST API

## Overview
A production-grade Spring Boot REST API for Student Management system with pagination and sorting capabilities.

## Technologies
- Java 21
- Spring Boot 3
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Jakarta Validation

## Project Structure
```
src/main/java/com/cts/student/
├── StudentApplication.java
├── controller/
│   └── StudentController.java
├── service/
│   └── StudentService.java
├── repository/
│   └── StudentRepository.java
├── entity/
│   └── Student.java
├── dto/
│   └── StudentDTO.java
└── exception/
    ├── StudentNotFoundException.java
    ├── DuplicateEmailException.java
    └── GlobalExceptionHandler.java
```

## Setup Instructions

1. **Database Setup**
   - Start MySQL server
   - Execute `src/main/resources/db.sql` script
   - Or let Hibernate auto-create the schema

2. **Configure Database Connection**
   Edit `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Build Project**
   ```bash
   mvn clean install
   ```

4. **Run Application**
   ```bash
   mvn spring-boot:run
   ```
   (Runs on port 8081)

## API Endpoints

### Get All Students (with Pagination and Sorting)
```
GET /api/students?page=0&size=10&sortBy=id&direction=ASC
```

### Get Student by ID
```
GET /api/students/{id}
```

### Create Student
```
POST /api/students
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@university.com",
  "phoneNumber": "9876543210",
  "courseCode": "CS101",
  "courseName": "Data Structures",
  "enrollmentDate": "2024-01-01",
  "gpa": 3.8
}
```

### Update Student
```
PUT /api/students/{id}
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Smith",
  "email": "john.smith@university.com",
  "phoneNumber": "9876543210",
  "courseCode": "CS101",
  "courseName": "Data Structures",
  "enrollmentDate": "2024-01-01",
  "gpa": 3.9
}
```

### Delete Student
```
DELETE /api/students/{id}
```

### Search Students by First Name (with Pagination)
```
GET /api/students/search/firstName?firstName=John&page=0&size=10&sortBy=firstName&direction=ASC
```

### Search Students by Last Name (with Pagination)
```
GET /api/students/search/lastName?lastName=Doe&page=0&size=10&sortBy=lastName&direction=ASC
```

### Search Students by Course Code (with Pagination)
```
GET /api/students/search/courseCode?courseCode=CS101&page=0&size=10&sortBy=courseCode&direction=ASC
```

## Features
- Layered Architecture (Controller → Service → Repository → Entity)
- Data Validation using Jakarta Validation
- Global Exception Handling
- ResponseEntity for RESTful responses
- Pagination and Sorting support
- MySQL database integration
- Search functionality with filtering
- Lombok for reducing boilerplate code
