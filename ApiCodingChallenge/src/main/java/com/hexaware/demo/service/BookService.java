package com.hexaware.demo.service;

import com.hexaware.demo.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookByIsbn(String isbn);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(String isbn, BookDTO bookDTO);
    void deleteBook(String isbn);
}
