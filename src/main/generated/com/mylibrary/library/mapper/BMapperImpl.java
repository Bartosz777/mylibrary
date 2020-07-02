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
public class BMapperImpl implements BMapper {

    @Override
    public Book mapToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setComments( commentDtoListToCommentList( bookDto.getCommentsDto() ) );
        book.setUser( userDtoToUser( bookDto.getUserDto() ) );
        book.setId( bookDto.getId() );
        book.setName( bookDto.getName() );
        book.setAuthor( bookDto.getAuthor() );
        book.setDescription( bookDto.getDescription() );

        return book;
    }

    @Override
    public BookDto mapToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setCommentsDto( commentListToCommentDtoList( book.getComments() ) );
        bookDto.setUserDto( mapToUserDto( book.getUser() ) );
        bookDto.setId( book.getId() );
        bookDto.setName( book.getName() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setDescription( book.getDescription() );

        return bookDto;
    }

    @Override
    public CommentDto mapToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setUserDto( mapToUserDto( comment.getUser() ) );
        commentDto.setId( comment.getId() );
        commentDto.setDescription( comment.getDescription() );

        return commentDto;
    }

    @Override
    public UserDto mapToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setPassword( user.getPassword() );
        userDto.setEnabled( user.isEnabled() );

        return userDto;
    }

    @Override
    public List<BookDto> mapToBookDtoList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( books.size() );
        for ( Book book : books ) {
            list.add( mapToBookDto( book ) );
        }

        return list;
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
}
