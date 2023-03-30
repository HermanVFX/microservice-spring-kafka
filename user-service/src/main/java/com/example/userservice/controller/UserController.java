package com.example.userservice.controller;

import com.example.userservice.dto.ShortUserDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(ShortUserDto shortUserDto) {
        UserDto newUser = userService.create(shortUserDto);
        userService.produce(newUser.getId());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> findUsersByDepartmentId(UUID departmentId) {
        List<UserDto> users = userService.findUsersByDepartmentId(departmentId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> findUsersById(UUID userId) {
//        List<UserDto> users = userService.findUsersById(userId);
//        return new ResponseEntity<>(users, HttpStatus.OK);
        return null;
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UUID userId, UserDto userDto) {
        return null;
    }
}
