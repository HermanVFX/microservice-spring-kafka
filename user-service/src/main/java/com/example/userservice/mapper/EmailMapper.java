package com.example.userservice.mapper;

import com.example.userservice.dto.EmailDto;
import com.example.userservice.model.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface EmailMapper {
    EmailDto emailToEmailDto(Email email);
}
