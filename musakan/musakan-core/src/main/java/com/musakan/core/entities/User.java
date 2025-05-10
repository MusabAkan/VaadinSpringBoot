package com.musakan.core.entities;

import com.musakan.core.entities.base.BaseEntity;
import com.musakan.core.enums.EnumRoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column(name = "email", length = 100, nullable = false, unique = true)
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private EnumRoleType role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @Column(name = "isActive")
    private Boolean isActive;
}