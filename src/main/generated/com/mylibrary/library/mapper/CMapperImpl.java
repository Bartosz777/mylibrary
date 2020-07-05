package com.mylibrary.library.mapper;

import com.mylibrary.library.domain.Book;
import com.mylibrary.library.domain.BookDto;
import com.mylibrary.library.domain.Comment;
import com.mylibrary.library.domain.CommentDto;
import com.mylibrary.library.domain.User;
import com.mylibrary.library.domain.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-02T15:10:41+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class CMapperImpl implements CMapper {

    @Override
    public Comment mapToComment(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setUser( userDtoToUser( commentDto.getUserDto() ) );
        comment.setBook( bookDtoToBook( commentDto.getBookDto() ) );
        comment.setId( commentDto.getId() );
        comment.setDescription( commentDto.getDescription() );

        return comment;
    }

    @Override
    public CommentDto mapToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setBookDto( mapToBookDto( comment.getBook() ) );
        commentDto.setUserDto( mapToUserDto( comment.getUser() ) );
        commentDto.setId( comment.getId() );
        commentDto.setDescription( comment.getDescription() );

        return commentDto;
    }

    @Override
    public BookDto mapToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setName( book.getName() );
        bookDto.setAuthor( book.getAuthor() );

        return bookDto;
    }

    @Override
    public UserDto mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );

        return userDto;
    }

    @Override
    public List<CommentDto> mapToCommentDtoList(List<Comment> commentList) {
        if ( commentList == null ) {
            return null;
        }

        List<CommentDto> list = new ArrayList<CommentDto>( commentList.size() );
        for ( Comment comment : commentList ) {
            list.add( mapToCommentDto( comment ) );
        }

        return list;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setEnabled( userDto.isEnabled() );
        user.setRole( userDto.getRole() );
        user.setEmail( userDto.getEmail() );

        return user;
    }

    protected Book bookDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setName( bookDto.getName() );
        book.setAuthor( bookDto.getAuthor() );
        book.setDescription( bookDto.getDescription() );
        book.setRented( bookDto.isRented() );

        return book;
    }
}
