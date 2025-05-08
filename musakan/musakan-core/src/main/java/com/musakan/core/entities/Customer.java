package com.musakan.core.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    public Customer() {
    }

    @Column(length = 50, name = "CustomerName")
    @Size(max = 50)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
