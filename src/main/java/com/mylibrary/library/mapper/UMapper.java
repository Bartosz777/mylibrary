package com.mylibrary.library.mapper;

import com.mylibrary.library.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UMapper {

    UMapper INSTANCE = Mappers.getMapper(UMapper.class);

    @Mappings({
            @Mapping(source = "rentBooks", target = "rentBooksDto"),
            @Mapping(source = "readBooks", target = "readBooksDto"),
            @Mapping(source = "comments", target = "commentsDto"),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "role", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    UserDto mapToUserDto(User user);

    @Mappings({
            @Mapping(source = "rentBooksDto", target = "rentBooks"),
            @Mapping(source = "readBooksDto", target = "readBooks"),
            @Mapping(source = "commentsDto", target = "comments")
    })
    User mapToUser(UserDto userDto);


    @Mappings({
            @Mapping(target = "description", ignore = true),
            @Mapping(target = "commentsDto", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    BookDto mapToBookDto(Book book);

    @Mappings({
            @Mapping(target = "userDto", ignore = true),
            @Mapping(source = "book", target = "bookDto"),
            @Mapping(target = "id", ignore = true)
    })
    CommentDto mapToCommentDto(Comment comment);

    List<UserDto> mapToUserDtoList(List<User> users);

}
