package com.hermanvfx.departmentservice.repository;

import com.hermanvfx.departmentservice.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface DepartmentRepository extends MongoRepository<Department, UUID> {
}
