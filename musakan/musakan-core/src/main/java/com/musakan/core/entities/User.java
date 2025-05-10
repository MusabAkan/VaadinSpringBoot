package com.musakan.core.entities;

import com.musakan.core.entities.base.BaseEntity;
import com.musakan.core.enums.EnumRoleType;
import com.musakan.core.enums.EnumStatusType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column(length = 100, nullable = false, unique = true)
    @Size(max = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private EnumRoleType role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EnumStatusType status;
}