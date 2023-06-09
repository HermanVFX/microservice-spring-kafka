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
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phone")
@Entity
public class Phone {
    @Id
    @Column(name = "phone_id", nullable = false)
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "work_phone", nullable = false)
    private String workPhone;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "alternative_phone")
    private String alternativePhone;

    @OneToOne(mappedBy = "phone")
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
