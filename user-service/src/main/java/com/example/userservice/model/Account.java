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

import java.time.OffsetDateTime;
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

    @Column(name = "account_balance", nullable = false)
    private Long balance;

    @OneToOne(mappedBy = "account")
    private User user;

    @Column(name = "create_time", nullable = false)
    private OffsetDateTime create;
    @Column(name = "update_time")
    private OffsetDateTime update;
    @Column(name = "delete_time")
    private OffsetDateTime delete;
    @Column(
            name = "is_active",
            nullable = false
    )
    private boolean isActive = true;
}
