package com.emirhan.baran.user_ms.dto;

import lombok.Data;

@Data
public class AddressRegisterDto {

    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
