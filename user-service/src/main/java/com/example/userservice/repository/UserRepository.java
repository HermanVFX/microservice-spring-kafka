package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    List<User> findAll();
    List<User> findAllByDepartmentId(UUID departmentId);
}
