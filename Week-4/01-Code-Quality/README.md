# 01 - Code Quality

This module demonstrates code quality best practices using a small Spring Boot service.

Key features:

- Java 21 and Spring Boot 3
- Maven build with static-analysis plugins (Checkstyle, PMD, SpotBugs)
- SonarQube configuration
- Clean architecture layers: controller, service, dto, exception
- Constructor injection and DTO pattern
- Global exception handling
- SLF4J logging via Lombok
- Validation using Jakarta Validation (JSR 380)
- Unit tests with JUnit 5 and Mockito
- Dockerfile for containerization

Structure

- src/main/java - application code
- src/test/java - unit tests
- application.yml - runtime configuration
- Dockerfile
- sonar-project.properties - SonarQube configuration
- checkstyle.xml - Checkstyle rules (minimal, extendable)

This module is intentionally small and focused on demonstrating code quality and project-level tooling. Other microservices will follow in subsequent modules.
