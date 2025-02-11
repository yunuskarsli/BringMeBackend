package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Users;

public class UserMapper {
    public static UserDto mapToUserDto(Users users){
        UserDto userDto=new UserDto();
        userDto.setId(users.getId());
        userDto.setUsername(users.getUsername());
        userDto.setSurname(users.getSurname());
        return userDto;
    }
    public static Users mapToUser(UserDto userDto){
        Users users=new Users();
        users.setId(userDto.getId());
        users.setUsername(userDto.getUsername());
        users.setSurname(users.getSurname());
        return users;
    }
}
