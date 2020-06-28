package com.mylibrary.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    private String author;

    private String description;

    private boolean isRented;

    @OneToMany(targetEntity = Comment.class, mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "comments")
    private List<Comment> comments;

    public Book(@NotNull String name, @NotNull String author, String description, @NotNull boolean isRented, List<Comment> comments) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.isRented = isRented;
        this.comments = comments;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
