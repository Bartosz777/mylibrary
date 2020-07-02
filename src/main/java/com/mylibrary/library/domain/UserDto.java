package com.mylibrary.library.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("username")
    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("password")
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("isEnabled")
    private boolean isEnabled;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("email")
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("role")
    private ROLE role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("commentsDto")
    private List<CommentDto> commentsDto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rentBooksDto")
    private List<BookDto> rentBooksDto;

    public UserDto(Long id, String username, String password, String email,ROLE role, boolean isEnabled,
                   List<CommentDto> commentsDto, List<BookDto> rentBooksDto) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isEnabled = isEnabled;
        this.commentsDto = commentsDto;
        this.rentBooksDto = rentBooksDto;
    }

    public UserDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<CommentDto> getCommentsDto() {
        return commentsDto;
    }

    public void setCommentsDto(List<CommentDto> commentsDto) {
        this.commentsDto = commentsDto;
    }

    public List<BookDto> getRentBooksDto() {
        return rentBooksDto;
    }

    public void setRentBooksDto(List<BookDto> rentBooksDto) {
        this.rentBooksDto = rentBooksDto;
    }
}
