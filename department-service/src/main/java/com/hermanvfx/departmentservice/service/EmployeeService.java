package com.hermanvfx.departmentservice.service;

import com.example.userservice.dto.DepartmentDto;
import com.example.userservice.dto.EmployeeDto;
import com.example.userservice.dto.UserDto;

public interface EmployeeService {

    void send(UserDto user);

    void consume(UserDto user);

}
