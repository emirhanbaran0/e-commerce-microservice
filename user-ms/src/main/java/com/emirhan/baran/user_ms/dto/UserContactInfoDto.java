package com.emirhan.baran.user_ms.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "user")
@Getter
@Setter
public class UserContactInfoDto {
    String message;
    Map<String,String> contactDetails;
    List<String> onCallSupport;
}
