package com.example.bmil_2_att.registration.controller;

import com.example.bmil_2_att.custom_exeption.Response;
import com.example.bmil_2_att.custom_exeption.exeptions.NotValidDataException;
import com.example.bmil_2_att.custom_exeption.exeptions.NotValidTapsException;
import com.example.bmil_2_att.registration.model.User;
import com.example.bmil_2_att.registration.model.UserDTO;
import com.example.bmil_2_att.repository.AuthenticationProvider;
import com.example.bmil_2_att.repository.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @GetMapping("/auth")
    public String authentication(UserDTO userDTO){
        return "auth";
    }

    @PostMapping( "/auth")
    public ResponseEntity<Response> authentication(@Valid UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new NotValidDataException("not valid data");
        }

        User user = authenticationProvider.loadUser(userDTO.getUsername(), userDTO.getPassword());
        boolean isAuth = authenticationProvider.isMatchUser(
                user,
                userService.convert(userDTO)
        );

        if (!isAuth){
            throw new NotValidTapsException("not valid taps");
        }

        return ResponseEntity.ok().build();
    }
}
