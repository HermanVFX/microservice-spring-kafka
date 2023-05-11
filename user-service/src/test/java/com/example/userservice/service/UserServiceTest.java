package com.example.userservice.service;

import com.example.userservice.IntegrationTestBase;
import com.example.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest extends IntegrationTestBase {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    private static final UUID FIRST_USER_ID = UUID.fromString("8d5f9db8-daa2-11ed-afa1-0242ac120002");
    private static final UUID SECOND_USER_ID = UUID.fromString("8d5fb15e-daa2-11ed-afa1-0242ac120002");

    @Test
    public void findByIdGreat() {
        var userFromRepository = userRepository.findById(FIRST_USER_ID)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        var userFromService = userService.findUserById(FIRST_USER_ID);

        assertEquals(userFromRepository.getFirstName(), userFromService.getFirstName());
    }

    @Test
    public void findByIdBad() {
        assertThrows(EntityNotFoundException.class, () -> userService.findUserById(
                UUID.fromString("573e518a-daab-11ed-afa1-0242ac120002")));
    }
}
