package com.musakan.core.entities;

import com.musakan.core.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "country")
public class Country extends BaseEntity {
    @Column(name = "name", length = 50)
    @Size(max = 50)
    private String name;

    @Column(name = "code", length = 10)
    @Size(max = 10)
    private String code;
}