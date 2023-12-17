package com.example.bmil_2_att.custom_exeption.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="taps is not concurent")
public class NotValidTapsException extends RuntimeException {
    public NotValidTapsException(String message) {
        super(message);
    }
}
