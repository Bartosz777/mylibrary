package com.mylibrary.library.controller;


import com.mylibrary.library.domain.BookDto;
import com.mylibrary.library.exception.ValueNotFoundException;
import com.mylibrary.library.mapper.BookMapper;
import com.mylibrary.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(bookService.addBook(bookMapper.mapToBook(bookDto)));
    }

    @PutMapping(value = "/update")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(bookService.addBook(bookMapper.mapToBook(bookDto)));
    }

    @GetMapping("/getall")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(bookService.getBooks());
    }

    @GetMapping("/getbyname")
    public BookDto getBookByName(@RequestParam(name = "name") String name) throws ValueNotFoundException {
        return bookMapper.mapToBookDto(bookService.getBookByName(name).orElseThrow(() -> new ValueNotFoundException("Value " + name + " not found exception")));
    }

    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam(name = "id") Long id) {
        bookService.delete(id);
    }

    @GetMapping("/getbyauthor")
    public BookDto getBookByAuthor(@RequestParam("author") String author) throws ValueNotFoundException {
        return bookMapper.mapToBookDto(bookService.getBookByAuthor(author).orElseThrow(() -> new ValueNotFoundException("Author " + author + " doesn't exist")));
    }

}
