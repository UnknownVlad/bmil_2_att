package com.example.bmil_2_att.registration.controller;



import com.example.bmil_2_att.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Controller
public class MainController {

    @Autowired
    private UserService userService;



    @GetMapping("/reg")
    public String registration(){
        return "registration";
    }


    @PostMapping( "/reg")
    public String registrationUser(@RequestParam String username, @RequestParam String password){
        System.out.println(username);
        System.out.println(password);
        return "registration";
    }

    /*@GetMapping("/filter9")
    public ResponseEntity<List<User>> get9(){
        System.out.println(f_9(userService.findAll()));
        return ResponseEntity.ok(
                f_9(userService.findAll())
        );
    }

    @GetMapping( "/filter11")
    public ResponseEntity<List<User>> get11(){
        System.out.println(f_11(userService.findAll()));
        return ResponseEntity.ok(
                f_11(userService.findAll())
        );
    }

    @GetMapping( "/filter7")
    public ResponseEntity<List<User>> get7(){
        System.out.println(f_7(userService.findAll()));
        return ResponseEntity.ok(
                f_7(userService.findAll())
        );
    }
    *//**
     * Вариант влада 9 - Вывести перечень всех
     * зарегистрированных пользователей, парольная фраза которых
     * заканчиваются символом «a».
     *//*
    public List<User> f_9(List<User> users){
        return filter(users, user ->
                user.getPassword().charAt(user.getPassword().length()-1) == 'a'
        );
    }

    *//**
     * Вариант леши 11 - Вывести перечень всех
     * зарегистрированных пользователей, в парольной фразе которых содержится
     * только буквы.
     *//*
    public List<User> f_11(List<User> users){
        return filter(users, user ->
                user.getPassword().chars().allMatch(Character::isLetter)
        );
    }


    *//**
     * Вариант кристины 7 - Вывести перечень всех
     * зарегистрированных пользователей, в парольной фразе которых не
     * содержится символы «123».
     *//*
    public List<User> f_7(List<User> users){
        return filter(users, user ->
                !(user.getPassword().contains("1") || user.getPassword().contains("2") || user.getPassword().contains("3"))
        );
    }



    public List<User> filter(List<User> users, Predicate<User> p){
        return users.stream()
                .filter(p)
                .collect(Collectors.toList());
    }*/






}