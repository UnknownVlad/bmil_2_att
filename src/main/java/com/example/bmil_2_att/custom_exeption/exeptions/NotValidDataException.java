package com.example.bmil_2_att.custom_exeption.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Not valid data")
public class NotValidDataException extends RuntimeException {

    public NotValidDataException(String message) {
        super(message);
    }
}
