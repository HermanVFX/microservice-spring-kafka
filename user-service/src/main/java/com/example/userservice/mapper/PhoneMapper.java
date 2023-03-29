package com.example.userservice.mapper;

import com.example.userservice.dto.PhoneDto;
import com.example.userservice.model.Phone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface PhoneMapper {
    PhoneDto phoneToPhoneDto(Phone phone);
}
