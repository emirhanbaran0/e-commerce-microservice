package com.emirhan.baran.user_ms.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.Instant;

@Data
public class UserRegisterDto {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Instant dateOfBirth;
    private String gender;


}
