package com.example.bmil_2_att.registration.controller;



import com.example.bmil_2_att.registration.model.User;
import com.example.bmil_2_att.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Controller
public class TaskController {

    @Autowired
    private UserService userService;

    @GetMapping("/firyulin")
    public String firyulin(Model model){
        List<User> users = userService.findAll();
        if(users == null){
            System.out.println("NOT FOUND");
            model.addAttribute("users_9", new ArrayList<>());
        }else {
            model.addAttribute("users_9", filterVlad(users));
            System.out.println(filterVlad(users));
        }
        return "var9";
    }

    @GetMapping("/nartova")
    public String nartova(Model model){
        List<User> users = userService.findAll();
        if(users == null){
            System.out.println("NOT FOUND");
            model.addAttribute("users_7", new ArrayList<>());
        }else {
            model.addAttribute("users_7", filterKristina(users));
            System.out.println(filterKristina(users));
        }
        return "var7";
    }

    @GetMapping("/shulgin")
    public String shulgin(Model model){
        List<User> users = userService.findAll();
        if(users == null){
            System.out.println("NOT FOUND");
            model.addAttribute("users_11", new ArrayList<>());
        }else {
            model.addAttribute("users_11", filterAlexey(users));
            System.out.println(filterAlexey(users));
        }
        return "var11";
    }


    /**
     * Вариант влада 9 - Вывести перечень всех
     * зарегистрированных пользователей, парольная фраза которых
     * заканчиваются символом «a».
     */
    private List<User> filterVlad(List<User> users){
        return filter(users, user ->
                user.getPassword().charAt(user.getPassword().length()-1) == 'a'
        );
    }

    /**
     * Вариант леши 11 - Вывести перечень всех
     * зарегистрированных пользователей, в парольной фразе которых содержится
     * только буквы.
     */
    private List<User> filterAlexey(List<User> users){
        return filter(users, user ->
                user.getPassword().chars().allMatch(Character::isLetter)
        );
    }


    /**
     * Вариант кристины 7 - Вывести перечень всех
     * зарегистрированных пользователей, в парольной фразе которых не
     * содержится символы «123».
     */
    private List<User> filterKristina(List<User> users){
        return filter(users, user ->
                !(user.getPassword().contains("1") || user.getPassword().contains("2") || user.getPassword().contains("3"))
        );
    }

    private List<User> filter(List<User> users, Predicate<User> p){
        return users.stream()
                .filter(p)
                .collect(Collectors.toList());
    }

}