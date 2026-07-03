# Book REST API

## Overview
A production-grade Spring Boot REST API for Book Management system with advanced search, filtering, pagination, and sorting capabilities.

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
src/main/java/com/cts/book/
├── BookApplication.java
├── controller/
│   └── BookController.java
├── service/
│   └── BookService.java
├── repository/
│   └── BookRepository.java
├── entity/
│   └── Book.java
├── dto/
│   └── BookDTO.java
└── exception/
    ├── BookNotFoundException.java
    ├── DuplicateIsbnException.java
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
   spring.datasource.url=jdbc:mysql://localhost:3306/book_db
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
   (Runs on port 8082)

## API Endpoints

### CRUD Operations

#### Get All Books (with Pagination and Sorting)
```
GET /api/books?page=0&size=10&sortBy=id&direction=ASC
```

#### Get Book by ID
```
GET /api/books/{id}
```

#### Create Book
```
POST /api/books
Content-Type: application/json

{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565",
  "price": 29.99,
  "publisher": "Scribner",
  "publicationDate": "1925-04-10",
  "category": "Fiction",
  "description": "A classic American novel",
  "totalCopies": 15,
  "availableCopies": 10
}
```

#### Update Book
```
PUT /api/books/{id}
Content-Type: application/json

{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565",
  "price": 34.99,
  "publisher": "Scribner",
  "publicationDate": "1925-04-10",
  "category": "Fiction",
  "description": "A classic American novel of the 1920s",
  "totalCopies": 20,
  "availableCopies": 15
}
```

#### Delete Book
```
DELETE /api/books/{id}
```

### Search Operations

#### Search Books by Title (with Pagination)
```
GET /api/books/search/title?title=Gatsby&page=0&size=10&sortBy=title&direction=ASC
```

#### Search Books by Author (with Pagination)
```
GET /api/books/search/author?author=Fitzgerald&page=0&size=10&sortBy=author&direction=ASC
```

### Filter Operations

#### Filter Books by Category (with Pagination)
```
GET /api/books/filter/category?category=Fiction&page=0&size=10&sortBy=category&direction=ASC
```

### Advanced Search

#### Search Books with Multiple Criteria
```
GET /api/books/search?title=Great&author=Fitzgerald&category=Fiction&availableOnly=true&page=0&size=10&sortBy=title&direction=ASC
```

Parameters:
- `title` (optional) - Search in book title
- `author` (optional) - Search in author name
- `category` (optional) - Filter by category
- `availableOnly` (optional) - Show only books with available copies
- `page` (default: 0) - Page number
- `size` (default: 10) - Page size
- `sortBy` (default: title) - Sort field
- `direction` (default: ASC) - Sort direction (ASC/DESC)

## Features
- Layered Architecture (Controller → Service → Repository → Entity)
- Data Validation using Jakarta Validation
- Global Exception Handling
- ResponseEntity for RESTful responses
- CRUD Operations
- Advanced Search by Title and Author
- Category Filtering
- Multi-criteria Search with Custom Query
- Pagination and Sorting support
- MySQL database integration with indexed columns
- Lombok for reducing boilerplate code
