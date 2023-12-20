package com.example.bmil_2_att.registration.controller;

import com.example.bmil_2_att.custom_exeption.Response;
import com.example.bmil_2_att.custom_exeption.exeptions.NotValidDataException;
import com.example.bmil_2_att.custom_exeption.exeptions.UserExistException;
import com.example.bmil_2_att.registration.model.User;
import com.example.bmil_2_att.registration.model.UserDTO;
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
public class RegistrationController {
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String registration(UserDTO userDTO){
        return "index";
    }
    @PostMapping( "/registration")
    public ResponseEntity<Response> registration(@Valid UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new NotValidDataException("not valid data");
        }

        User user = userService.findByUsername(userDTO.getUsername());

        if(user != null){
            throw new UserExistException("User with username <%s> already exist".formatted(userDTO.getUsername()));
        }else {
            userService.save(
                    userDTO
            );
        }
        System.out.println("++++");
        System.out.println(userDTO);
        return ResponseEntity.ok().build();
    }
}
