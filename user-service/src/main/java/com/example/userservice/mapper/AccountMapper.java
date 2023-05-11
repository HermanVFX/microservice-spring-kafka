package com.example.userservice.mapper;

import com.example.userservice.dto.AccountDto;
import com.example.userservice.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto accountToAccountDto(Account account);
}
