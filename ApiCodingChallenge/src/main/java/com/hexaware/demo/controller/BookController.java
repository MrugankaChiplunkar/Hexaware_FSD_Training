package com.hexaware.demo.controller;

import com.hexaware.demo.dto.BookDTO;
import com.hexaware.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> getBook(@PathVariable String isbn) {
        return ResponseEntity.ok(service.getBookByIsbn(isbn));
    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = service.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook); 
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable String isbn, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(service.updateBook(isbn, bookDTO));
    }

    @DeleteMapping("/{isbn}")
    @Transactional
    public ResponseEntity<String> deleteBook(@PathVariable String isbn) {
        service.deleteBook(isbn);
        return ResponseEntity.ok("Book deleted successfully.");
    }
}
