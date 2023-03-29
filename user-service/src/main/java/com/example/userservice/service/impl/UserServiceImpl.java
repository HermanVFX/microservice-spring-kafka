package com.example.userservice.service.impl;

import com.example.userservice.dto.ShortUserDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userMapper.listUserToListUserDto(userRepository.findAllUser());
    }

    @Override
    public List<UserDto> findUsersByDepartmentId(UUID departmentId) {
        return userMapper.listUserToListUserDto(userRepository.findAllByDepartmentId(departmentId));
    }

    @Override
    public List<UserDto> findUsersById(UUID userId) {
        return userMapper.listUserToListUserDto(userRepository.findAllById(userId));
    }

    @Transactional
    @Override
    public UserDto create(ShortUserDto user) {
        User newUser = userMapper.shortUserDtoToUser(user);
        return userMapper.userToUserDto(userRepository.save(newUser));
    }

    @Transactional
    @Override
    public UserDto update(UserDto user, UUID id) {
        return null;
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
