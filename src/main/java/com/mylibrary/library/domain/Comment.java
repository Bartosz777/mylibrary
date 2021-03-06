package com.mylibrary.library.domain;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Book.class)
    private Book book;

    public Comment(Long id, String description, User user, Book book) {
        this.id = id;
        this.description = description;
        this.user = user;
        this.book = book;
    }

    public Comment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
