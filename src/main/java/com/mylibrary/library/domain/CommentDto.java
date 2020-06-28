package com.mylibrary.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("description")
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "user")
    private UserDto userDto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("book")
    private BookDto bookDto;

    public CommentDto(Long id, String description, UserDto userDto, BookDto bookDto) {
        this.id = id;
        this.description = description;
        this.userDto = userDto;
        this.bookDto = bookDto;
    }

    public CommentDto() {
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}

