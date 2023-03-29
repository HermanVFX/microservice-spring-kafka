package com.example.userservice.repository;

import com.example.userservice.model.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PhoneRepository extends CrudRepository<Phone, UUID> {
}
