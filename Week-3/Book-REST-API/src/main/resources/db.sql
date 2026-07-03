CREATE DATABASE IF NOT EXISTS book_db;

USE book_db;

CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    price DOUBLE NOT NULL,
    publisher VARCHAR(100) NOT NULL,
    publication_date DATE NOT NULL,
    category VARCHAR(50) NOT NULL,
    description TEXT,
    total_copies INT NOT NULL DEFAULT 0,
    available_copies INT NOT NULL DEFAULT 0,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_title (title),
    INDEX idx_author (author),
    INDEX idx_category (category),
    INDEX idx_isbn (isbn)
);

INSERT INTO books (title, author, isbn, price, publisher, publication_date, category, description, total_copies, available_copies, is_active)
VALUES 
('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', 29.99, 'Scribner', '1925-04-10', 'Fiction', 'A classic American novel', 15, 10, TRUE),
('To Kill a Mockingbird', 'Harper Lee', '9780061120084', 24.99, 'J.B. Lippincott', '1960-07-11', 'Fiction', 'Pulitzer Prize winning novel', 20, 18, TRUE),
('1984', 'George Orwell', '9780451524935', 27.99, 'Signet Classics', '1949-06-08', 'Science Fiction', 'Dystopian novel', 12, 8, TRUE),
('Clean Code', 'Robert C. Martin', '9780132350884', 45.00, 'Prentice Hall', '2008-08-01', 'Programming', 'A Handbook of Agile Software Craftsmanship', 25, 22, TRUE),
('Design Patterns', 'Gang of Four', '9780201633610', 89.99, 'Addison-Wesley', '1994-10-31', 'Programming', 'Elements of Reusable Object-Oriented Software', 10, 7, TRUE);
