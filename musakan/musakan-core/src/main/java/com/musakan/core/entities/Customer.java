package com.musakan.core.entities;

import com.musakan.core.entities.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "name", length = 50)
    @Size(max = 50)
    private String name;

    @Column(name = "lastName", length = 50)
    @Size(max = 50)
    private String lastName;
}
