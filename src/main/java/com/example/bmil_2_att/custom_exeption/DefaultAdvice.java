package com.example.bmil_2_att.custom_exeption;

import com.example.bmil_2_att.custom_exeption.exeptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotEqPasswordException.class)
    public ResponseEntity<Response> handle1(NotEqPasswordException e) {
        Response response = new Response(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NotValidDataException.class)
    public ResponseEntity<Response> handle3(NotValidDataException e) {
        Response response = new Response(e.getMessage(), HttpStatus.FORBIDDEN.value());
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(NotValidTapsException.class)
    public ResponseEntity<Response> handle3(NotValidTapsException e) {
        Response response = new Response(e.getMessage(), HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<Response> handle4(UserExistException e) {
        Response response = new Response(e.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<Response> handle5(UserNotExistException e) {
        Response response = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }








}
