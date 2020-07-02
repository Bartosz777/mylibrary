package com.mylibrary.library.repository;


import com.mylibrary.library.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Override
    Comment save(Comment comment);

    @Override
    void deleteById(Long id);
}
