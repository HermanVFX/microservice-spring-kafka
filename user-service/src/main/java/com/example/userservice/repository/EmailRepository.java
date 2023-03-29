package com.example.userservice.repository;

import com.example.userservice.model.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmailRepository extends CrudRepository<Email, UUID> {
}
