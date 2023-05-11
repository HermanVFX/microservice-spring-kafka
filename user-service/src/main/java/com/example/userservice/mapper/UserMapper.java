package com.example.userservice.mapper;

import com.example.userservice.dto.ShortUserDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                AccountMapper.class,
                EmailMapper.class,
                PhoneMapper.class
        })
public interface UserMapper {

    UserDto userToUserDto(User entity);

    User userDtoToUser(UserDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departmentId", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "account", ignore = true)
    User shortUserDtoToUser(ShortUserDto user);

    List<UserDto> listUserToListUserDto(List<User> entities);

}
