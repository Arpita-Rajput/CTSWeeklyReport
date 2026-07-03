package com.cts.book.repository;

import com.cts.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Book> findByAuthorContainingIgnoreCase(String author, Pageable pageable);
    Page<Book> findByCategory(String category, Pageable pageable);
    Page<Book> findByIsActiveTrue(Pageable pageable);
    
    @Query("SELECT b FROM Book b WHERE (b.title LIKE CONCAT('%', :title, '%') OR :title IS NULL) " +
           "AND (b.author LIKE CONCAT('%', :author, '%') OR :author IS NULL) " +
           "AND (b.category = :category OR :category IS NULL) " +
           "AND (b.availableCopies > 0 OR :availableOnly = false)")
    Page<Book> searchBooks(@Param("title") String title, @Param("author") String author, 
                          @Param("category") String category, @Param("availableOnly") Boolean availableOnly,
                          Pageable pageable);
}
