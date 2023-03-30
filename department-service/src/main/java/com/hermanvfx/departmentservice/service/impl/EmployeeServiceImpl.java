package com.hermanvfx.departmentservice.service.impl;

import com.example.userservice.dto.DepartmentDto;
import com.example.userservice.dto.EmployeeDto;
import com.example.userservice.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hermanvfx.departmentservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<Long, UserDto> kafkaStarshipTemplate;

    @Override
    public void send(UserDto user) {
        log.info("<= sending {}", writeValueAsString(user));
        kafkaStarshipTemplate.send("server.user", user);
    }

    @Override
    @KafkaListener(id = "User", topics = {"server.user"}, containerFactory = "singleFactory")
    public void consume(UserDto user) {
        log.info("=> consumed {}", writeValueAsString(user));
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
