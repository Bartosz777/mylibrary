package com.mylibrary.library.mapper;

import com.mylibrary.library.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CMapper {

    CMapper INSTANCE = Mappers.getMapper(CMapper.class);

    @Mappings({
            @Mapping(source = "userDto", target = "user"),
            @Mapping(source = "bookDto", target = "book")
    })
    Comment mapToComment(CommentDto commentDto);


    @Mappings({
            @Mapping(source = "user", target = "userDto"),
            @Mapping(source = "book", target = "bookDto"),
            @Mapping(target = "id", ignore = true)
    })
    CommentDto mapToCommentDto(Comment comment);

    @Mappings({
            @Mapping(target = "description", ignore = true),
            @Mapping(target = "commentsDto", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    BookDto mapToBookDto(Book book);

    @Mappings({
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "role", ignore = true),
            @Mapping(target = "commentsDto", ignore = true),
            @Mapping(target = "rentBooksDto", ignore = true),
            @Mapping(target = "readBooksDto", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    UserDto mapToUserDto(User user);

    List<CommentDto> mapToCommentDtoList(List<Comment> commentList);

}
