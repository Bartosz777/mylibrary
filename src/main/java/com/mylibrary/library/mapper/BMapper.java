package com.mylibrary.library.mapper;

import com.mylibrary.library.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BMapper {

    BMapper INSTANCE = Mappers.getMapper(BMapper.class);

    @Mapping(source = "commentsDto", target = "comments")
    Book mapToBook(BookDto bookDto);

    @Mappings({
            @Mapping(ignore = true, target = "id"),
            @Mapping(source = "comments", target = "commentsDto")
    })
    BookDto mapToBookDto(Book book);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "bookDto", ignore = true),
            @Mapping(source = "user", target = "userDto")
    })
    CommentDto mapToCommentDto(Comment comment);

    @Mappings({
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "role", ignore = true),
            @Mapping(target = "commentsDto", ignore = true),
            @Mapping(target = "rentBooksDto", ignore = true),
            @Mapping(target = "readBooksDto", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    UserDto mapToUserDto(User user);


    List<BookDto> mapToBookDtoList(List<Book> books);

}
