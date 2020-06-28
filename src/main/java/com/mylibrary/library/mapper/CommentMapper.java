package com.mylibrary.library.mapper;

import com.mylibrary.library.domain.Comment;
import com.mylibrary.library.domain.CommentDto;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommentMapper {

    public Comment mapToComment(final CommentDto commentDto) {
        return CMapper.INSTANCE.mapToComment(commentDto);
    }

    public CommentDto mapToCommentDto(final Comment comment) {
        return CMapper.INSTANCE.mapToCommentDto(comment);
    }

    public List<CommentDto> mapToCommentDtoList(final List<Comment> comments) {
        return CMapper.INSTANCE.mapToCommentDtoList(comments);
    }

}
