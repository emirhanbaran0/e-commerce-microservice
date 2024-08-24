package com.emirhan.baran.user_ms.dto;

import lombok.Data;
import java.time.Instant;

@Data
public class UserProfileDto {

    private String username;
    private String email;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String profilePicture;
    private Instant dateOfBirth;
    private String gender;
}
