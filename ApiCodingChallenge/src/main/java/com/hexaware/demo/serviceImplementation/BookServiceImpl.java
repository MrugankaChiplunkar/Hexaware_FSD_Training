package com.hexaware.demo.serviceImplementation;

import com.hexaware.demo.dto.BookDTO;
import com.hexaware.demo.entity.Book;
import com.hexaware.demo.exception.*;
import com.hexaware.demo.repository.BookRepository;
import com.hexaware.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public List<BookDTO> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(book -> new BookDTO(
                        book.getIsbn(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublicationYear()))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookByIsbn(String isbn) {
        Book book = repository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
        return new BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        if (repository.existsByIsbn(bookDTO.getIsbn())) {
            throw new BookAlreadyExistsException("Book with ISBN already exists: " + bookDTO.getIsbn());
        }

        Book book = new Book(
            bookDTO.getIsbn(),
            bookDTO.getTitle(),
            bookDTO.getAuthor(),
            bookDTO.getPublicationYear()
        );

        System.out.println("==> Book object being saved: " + book);

        Book saved = repository.save(book);

        System.out.println("✅ Book saved: " + saved.getIsbn()); // TEMP DEBUG LINE

        return new BookDTO(saved.getIsbn(), saved.getTitle(), saved.getAuthor(), saved.getPublicationYear());
    }


    @Override
    public BookDTO updateBook(String isbn, BookDTO bookDTO) {
        Book existingBook = repository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPublicationYear(bookDTO.getPublicationYear());

        Book updatedBook = repository.save(existingBook);

        return new BookDTO(updatedBook.getIsbn(), updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getPublicationYear());
    }

    @Override
    public void deleteBook(String isbn) {
        if (!repository.existsByIsbn(isbn)) {
            throw new BookNotFoundException("Book not found with ISBN: " + isbn);
        }
        repository.deleteByIsbn(isbn);
    }
}
