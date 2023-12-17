package com.example.bmil_2_att.custom_exeption.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="the wrong password")
public class NotEqPasswordException extends RuntimeException {
    public NotEqPasswordException(String message) {
        super(message);
    }
}
