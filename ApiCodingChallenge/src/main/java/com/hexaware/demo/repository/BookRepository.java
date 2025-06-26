package com.hexaware.demo.repository;

import com.hexaware.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);
    void deleteByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
}
