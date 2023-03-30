package com.example.userservice.service;

import com.example.userservice.dto.ShortUserDto;
import com.example.userservice.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDto> findAll();

    List<UserDto> findUsersByDepartmentId(UUID departmentId);

    UserDto findUserById(UUID userId);

    UserDto create(ShortUserDto user);

    UserDto update(UserDto user, UUID id);

    void delete(UUID id);

    void produce(UUID userId);

}
