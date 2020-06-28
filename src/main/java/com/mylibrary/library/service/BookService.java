package com.mylibrary.library.service;

import com.mylibrary.library.domain.Book;
import com.mylibrary.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookByName(String name) {
        return bookRepository.findByName(name);
    }

    public Optional<Book> getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
