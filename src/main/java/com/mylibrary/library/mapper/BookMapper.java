package com.mylibrary.library.mapper;

import com.mylibrary.library.domain.Book;
import com.mylibrary.library.domain.BookDto;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return BMapper.INSTANCE.mapToBook(bookDto);
    }

    public BookDto mapToBookDto(final Book book) {
        return BMapper.INSTANCE.mapToBookDto(book);
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books) {
        return BMapper.INSTANCE.mapToBookDtoList(books);

    }

}
