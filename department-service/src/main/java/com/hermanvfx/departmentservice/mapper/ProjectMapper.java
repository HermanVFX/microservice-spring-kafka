package com.hermanvfx.departmentservice.mapper;

import com.example.userservice.dto.ProjectDto;
import com.hermanvfx.departmentservice.model.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDto ProjectToProjectDto(Project entity);

}
