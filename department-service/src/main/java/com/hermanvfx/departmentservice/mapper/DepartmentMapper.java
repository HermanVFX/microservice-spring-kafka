package com.hermanvfx.departmentservice.mapper;

import com.example.userservice.dto.DepartmentDto;
import com.example.userservice.dto.ShortDepartmentDto;
import com.hermanvfx.departmentservice.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDto DepartmentToDepartmentDto(Department entity);

    Department ShortDepartmentDtoToDepartment(ShortDepartmentDto departmentData);

}
