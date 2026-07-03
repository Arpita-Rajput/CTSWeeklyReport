package com.cts.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false, length = 13, unique = true)
    private String isbn;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 100)
    private String publisher;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer totalCopies;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer availableCopies;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
