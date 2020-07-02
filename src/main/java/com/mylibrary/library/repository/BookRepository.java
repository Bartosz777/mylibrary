package com.mylibrary.library.repository;


import com.mylibrary.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Book save(Book book);

    @Override
    List<Book> findAll();

    @Override
    void deleteById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> findByAuthor(String author);

}
