package com.musakan.core.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String phoneNumber;
}
