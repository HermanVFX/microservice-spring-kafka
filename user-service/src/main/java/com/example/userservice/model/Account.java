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

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
@Entity
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private Date registrationDate;

    private Date updateDate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToOne(mappedBy = "account")
    private User user;
}
