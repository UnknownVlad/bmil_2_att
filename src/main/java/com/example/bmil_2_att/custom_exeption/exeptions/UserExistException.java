package com.example.bmil_2_att.custom_exeption.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Email already used")
public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}
