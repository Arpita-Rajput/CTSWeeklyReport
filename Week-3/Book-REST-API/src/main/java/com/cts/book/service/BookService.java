package com.cts.book.service;

import com.cts.book.dto.BookDTO;
import com.cts.book.entity.Book;
import com.cts.book.exception.BookNotFoundException;
import com.cts.book.exception.DuplicateIsbnException;
import com.cts.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Page<BookDTO> getAllBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findByIsActiveTrue(pageable);
        return books.map(this::convertToDTO);
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        return convertToDTO(book);
    }

    public BookDTO createBook(BookDTO bookDTO) {
        if (bookRepository.findByIsbn(bookDTO.getIsbn()).isPresent()) {
            throw new DuplicateIsbnException("Book with ISBN " + bookDTO.getIsbn() + " already exists");
        }
        Book book = convertToEntity(bookDTO);
        book.setIsActive(true);
        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        if (!book.getIsbn().equals(bookDTO.getIsbn()) &&
                bookRepository.findByIsbn(bookDTO.getIsbn()).isPresent()) {
            throw new DuplicateIsbnException("ISBN " + bookDTO.getIsbn() + " is already in use");
        }

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPrice(bookDTO.getPrice());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublicationDate(bookDTO.getPublicationDate());
        book.setCategory(bookDTO.getCategory());
        book.setDescription(bookDTO.getDescription());
        book.setTotalCopies(bookDTO.getTotalCopies());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        book.setIsActive(bookDTO.getIsActive());

        Book updatedBook = bookRepository.save(book);
        return convertToDTO(updatedBook);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        bookRepository.delete(book);
    }

    public Page<BookDTO> searchByTitle(String title, Pageable pageable) {
        Page<Book> books = bookRepository.findByTitleContainingIgnoreCase(title, pageable);
        return books.map(this::convertToDTO);
    }

    public Page<BookDTO> searchByAuthor(String author, Pageable pageable) {
        Page<Book> books = bookRepository.findByAuthorContainingIgnoreCase(author, pageable);
        return books.map(this::convertToDTO);
    }

    public Page<BookDTO> filterByCategory(String category, Pageable pageable) {
        Page<Book> books = bookRepository.findByCategory(category, pageable);
        return books.map(this::convertToDTO);
    }

    public Page<BookDTO> searchBooks(String title, String author, String category, 
                                       Boolean availableOnly, Pageable pageable) {
        Page<Book> books = bookRepository.searchBooks(title, author, category, availableOnly != null ? availableOnly : false, pageable);
        return books.map(this::convertToDTO);
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setPrice(book.getPrice());
        dto.setPublisher(book.getPublisher());
        dto.setPublicationDate(book.getPublicationDate());
        dto.setCategory(book.getCategory());
        dto.setDescription(book.getDescription());
        dto.setTotalCopies(book.getTotalCopies());
        dto.setAvailableCopies(book.getAvailableCopies());
        dto.setIsActive(book.getIsActive());
        return dto;
    }

    private Book convertToEntity(BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPrice(dto.getPrice());
        book.setPublisher(dto.getPublisher());
        book.setPublicationDate(dto.getPublicationDate());
        book.setCategory(dto.getCategory());
        book.setDescription(dto.getDescription());
        book.setTotalCopies(dto.getTotalCopies());
        book.setAvailableCopies(dto.getAvailableCopies());
        return book;
    }
}
