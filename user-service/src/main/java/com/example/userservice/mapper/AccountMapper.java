package com.example.userservice.mapper;

import com.example.userservice.dto.AccountDto;
import com.example.userservice.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface AccountMapper {

    @Mapping(target = "isActive", ignore = true)
    AccountDto accountToAccountDto(Account account);
}
