package com.hermanvfx.departmentservice.mapper;

import com.example.userservice.dto.EmployeeDto;
import com.hermanvfx.departmentservice.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto EmployeeToEmployeeDto(Employee entity);

}
