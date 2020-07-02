package com.mylibrary.library.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("description")
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("isRented")
    private boolean isRented;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("comments")
    private List<CommentDto> commentsDto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("user")
    private UserDto userDto;

    public BookDto(Long id, String name, String author, String description, boolean isRented, List<CommentDto> commentsDto, UserDto userDto) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.isRented = isRented;
        this.commentsDto = commentsDto;
        this.userDto = userDto;
    }

    public BookDto() {

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

    public List<CommentDto> getCommentsDto() {
        return commentsDto;
    }

    public void setCommentsDto(List<CommentDto> commentsDto) {
        this.commentsDto = commentsDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

}

