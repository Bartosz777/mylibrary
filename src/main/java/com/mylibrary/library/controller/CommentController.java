package com.mylibrary.library.controller;


import com.mylibrary.library.domain.CommentDto;
import com.mylibrary.library.mapper.CommentMapper;
import com.mylibrary.library.service.CommentService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentMapper commentMapper;
    private CommentService commentService;

    public CommentController(CommentMapper commentMapper, CommentService commentService) {
        this.commentMapper = commentMapper;
        this.commentService = commentService;
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public CommentDto addComment(@RequestBody CommentDto commentDto) {
        return commentMapper.mapToCommentDto(commentService.addComment(commentMapper.mapToComment(commentDto)));
    }

    @DeleteMapping("/delete")
    public void deleteComment(@RequestParam(name = "id") Long id) {
        commentService.deleteComment(id);
    }

}
