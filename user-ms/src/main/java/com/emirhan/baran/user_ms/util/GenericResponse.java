package com.emirhan.baran.user_ms.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse {

    private int code;
    private String message;
    private Object data;
}
