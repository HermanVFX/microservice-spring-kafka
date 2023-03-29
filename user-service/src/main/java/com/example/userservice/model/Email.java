package com.example.userservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "email")
@Entity
public class Email {
    @Id
    @Column(name = "email_id", nullable = false)
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @OneToOne(mappedBy = "email")
    private User user;
}
