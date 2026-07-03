# Hibernate CRUD - Product Management

Product Management application with Hibernate ORM, One-to-Many and Many-to-One relationships.

Requirements:
- Java 21
- Spring Boot 3
- MySQL
- Hibernate

Setup MySQL:
CREATE DATABASE product_db;

Run:
mvn clean spring-boot:run

APIs:
GET    /api/products
GET    /api/products/{id}
POST   /api/products
PUT    /api/products/{id}
DELETE /api/products/{id}
GET    /api/categories
GET    /api/categories/{id}
