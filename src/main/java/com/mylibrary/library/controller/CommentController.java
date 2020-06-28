package com.mylibrary.library.controller;

import com.mylibrary.library.domain.Comment;
import com.mylibrary.library.domain.CommentDto;
import com.mylibrary.library.mapper.CommentMapper;
import com.mylibrary.library.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {

    private CommentMapper commentMapper;
    private CommentService commentService;

    public CommentController(CommentMapper commentMapper, CommentService commentService) {
        this.commentMapper = commentMapper;
        this.commentService = commentService;
    }

    @PostMapping("/add")
    @ResponseBody
    public CommentDto addComment(@RequestBody Comment comment) {
        return commentMapper.mapToCommentDto(commentService.addComment(comment));
    }

    @DeleteMapping("/delete")
    public void deleteComment(@RequestParam(name = "id") Long id) {
        commentService.deleteComment(id);
    }

}
