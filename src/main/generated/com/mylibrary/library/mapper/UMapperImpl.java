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
    date = "2020-07-02T14:57:10+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class UMapperImpl implements UMapper {

    @Override
    public UserDto mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setCommentsDto( commentListToCommentDtoList( user.getComments() ) );
        userDto.setRentBooksDto( bookListToBookDtoList( user.getRentBooks() ) );
        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );
        userDto.setEnabled( user.isEnabled() );

        return userDto;
    }

    @Override
    public User mapToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setRentBooks( bookDtoListToBookList( userDto.getRentBooksDto() ) );
        user.setComments( commentDtoListToCommentList( userDto.getCommentsDto() ) );
        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setEnabled( userDto.isEnabled() );
        user.setRole( userDto.getRole() );
        user.setEmail( userDto.getEmail() );

        return user;
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
        bookDto.setRented( book.isRented() );

        return bookDto;
    }

    @Override
    public CommentDto mapToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setBookDto( mapToBookDto( comment.getBook() ) );
        commentDto.setId( comment.getId() );
        commentDto.setDescription( comment.getDescription() );

        return commentDto;
    }

    @Override
    public List<UserDto> mapToUserDtoList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( mapToUserDto( user ) );
        }

        return list;
    }

    protected List<CommentDto> commentListToCommentDtoList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentDto> list1 = new ArrayList<CommentDto>( list.size() );
        for ( Comment comment : list ) {
            list1.add( mapToCommentDto( comment ) );
        }

        return list1;
    }

    protected List<BookDto> bookListToBookDtoList(List<Book> list) {
        if ( list == null ) {
            return null;
        }

        List<BookDto> list1 = new ArrayList<BookDto>( list.size() );
        for ( Book book : list ) {
            list1.add( mapToBookDto( book ) );
        }

        return list1;
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

    protected List<Book> bookDtoListToBookList(List<BookDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Book> list1 = new ArrayList<Book>( list.size() );
        for ( BookDto bookDto : list ) {
            list1.add( bookDtoToBook( bookDto ) );
        }

        return list1;
    }

    protected Comment commentDtoToComment(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentDto.getId() );
        comment.setDescription( commentDto.getDescription() );

        return comment;
    }

    protected List<Comment> commentDtoListToCommentList(List<CommentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Comment> list1 = new ArrayList<Comment>( list.size() );
        for ( CommentDto commentDto : list ) {
            list1.add( commentDtoToComment( commentDto ) );
        }

        return list1;
    }
}
