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
            @Mapping(source = "comments", target = "commentsDto"),
            @Mapping(source = "rentBooks", target = "rentBooksDto"),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "role", ignore = true)
    })
    UserDto mapToUserDto(User user);

    @Mappings({
            @Mapping(source = "rentBooksDto", target = "rentBooks"),
            @Mapping(source = "commentsDto", target = "comments")
    })
    User mapToUser(UserDto userDto);


    @Mappings({
            @Mapping(target = "description", ignore = true),
            @Mapping(target = "commentsDto", ignore = true),
            @Mapping(target = "userDto", ignore = true)

    })
    BookDto mapToBookDto(Book book);

    @Mappings({
            @Mapping(target = "userDto", ignore = true),
            @Mapping(source = "book", target = "bookDto"),
    })
    CommentDto mapToCommentDto(Comment comment);

    List<UserDto> mapToUserDtoList(List<User> users);

}
