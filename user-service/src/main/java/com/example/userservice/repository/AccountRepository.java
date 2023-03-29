package com.example.userservice.repository;

import com.example.userservice.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {
}
