# Employee REST API

## Overview
A production-grade Spring Boot REST API for Employee Management system.

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
src/main/java/com/cts/employee/
├── EmployeeApplication.java
├── controller/
│   └── EmployeeController.java
├── service/
│   └── EmployeeService.java
├── repository/
│   └── EmployeeRepository.java
├── entity/
│   └── Employee.java
├── dto/
│   └── EmployeeDTO.java
└── exception/
    ├── EmployeeNotFoundException.java
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
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
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

## API Endpoints

### Get All Employees
```
GET /api/employees
```

### Get Employee by ID
```
GET /api/employees/{id}
```

### Create Employee
```
POST /api/employees
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "phoneNumber": "9876543210",
  "department": "Engineering",
  "salary": 75000,
  "dateOfJoining": "2024-01-01"
}
```

### Update Employee
```
PUT /api/employees/{id}
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Smith",
  "email": "john.smith@example.com",
  "phoneNumber": "9876543210",
  "department": "Engineering",
  "salary": 80000,
  "dateOfJoining": "2024-01-01"
}
```

### Delete Employee
```
DELETE /api/employees/{id}
```

## Features
- Layered Architecture (Controller → Service → Repository → Entity)
- Data Validation using Jakarta Validation
- Global Exception Handling
- ResponseEntity for RESTful responses
- MySQL database integration
- Lombok for reducing boilerplate code
