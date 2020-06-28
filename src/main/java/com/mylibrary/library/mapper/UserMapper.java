package com.mylibrary.library.mapper;

import com.mylibrary.library.domain.User;
import com.mylibrary.library.domain.UserDto;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return UMapper.INSTANCE.mapToUser(userDto);
    }

    public UserDto mapToUserDto(final User user) {
        return UMapper.INSTANCE.mapToUserDto(user);
    }


    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return UMapper.INSTANCE.mapToUserDtoList(users);
    }
}
