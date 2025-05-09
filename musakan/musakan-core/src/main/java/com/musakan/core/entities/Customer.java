package com.musakan.core.entities;

import com.musakan.core.entities.base.BaseEntity;
import com.musakan.core.entities.enums.EnumGenderType;
import com.musakan.core.entities.enums.EnumPhoneType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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

    @Column(name = "phone", length = 15)
    @Size(max = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Size(max = 30)
    private EnumPhoneType phoneType;

    @Enumerated(EnumType.STRING)
    @Size(max = 30)
    private EnumGenderType genderType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", nullable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId", nullable = false)
    private City city;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "isActive")
    private Boolean isActive;
}
