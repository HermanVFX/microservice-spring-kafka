package com.example.userservice.service.impl;

import com.example.userservice.dto.ShortUserDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.mapper.PhoneMapper;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PhoneMapper phoneMapper;
    private final UserMapper userMapper;

    private final KafkaTemplate<Long, UserDto> kafkaStarshipTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public List<UserDto> findAll() {
        return userMapper.listUserToListUserDto(userRepository.findAll());
    }

    @Override
    public List<UserDto> findUsersByDepartmentId(UUID departmentId) {
        return userMapper.listUserToListUserDto(userRepository.findAllByDepartmentId(departmentId));
    }

    @Override
    public UserDto findUserById(UUID userId) {
        return userMapper.userToUserDto(userRepository.findById(userId)
                .orElseThrow());
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
        userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id [" + id + "] does not found"));
        User updateUser = userMapper.userDtoToUser(user);
        return userMapper.userToUserDto(userRepository.save(updateUser));
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public void produce(UUID userId) {
        UserDto dto = userMapper.userToUserDto(userRepository.findById(userId)
                .orElseThrow());
        log.info("<= sending {}", writeValueAsString(dto));
        kafkaStarshipTemplate.send("test", dto);
    }

    private String writeValueAsString(UserDto user) {
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + user.toString());
        }
    }
}
