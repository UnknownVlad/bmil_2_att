package com.example.bmil_2_att.controller;



import com.example.bmil_2_att.model.User;
import com.example.bmil_2_att.model.UserDTO;
import com.example.bmil_2_att.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Controller
public class MainController {

    @Autowired
    private UserService userService;




    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll(){
        System.out.println(userService.findAll());
        return ResponseEntity.ok(
                userService.findAll()
        );
    }

    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public void registrationUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        userService.save(userDTO);
    }


    /**
     * Вариант влада 9 - Вывести перечень всех
     * зарегистрированных пользователей, парольная фраза которых
     * заканчиваются символом «a».
     */
    public List<User> f_9(List<User> users){
        return filter(users, user ->
                user.getPassword().charAt(user.getPassword().length()-1) == 'a'
        );
    }

    /**
     * Вариант леши 11 - Вывести перечень всех
     * зарегистрированных пользователей, в парольной фразе которых содержится
     * только буквы.
     */
    public List<User> f_11(List<User> users){
        return filter(users, user ->
                user.getPassword().chars().allMatch(Character::isLetter)
        );
    }


    /**
     * Вариант кристины 7 - Вывести перечень всех
     * зарегистрированных пользователей, в парольной фразе которых не
     * содержится символы «123».
     */
    public List<User> f_7(List<User> users){
        return filter(users, user ->
                !(user.getPassword().contains("1") || user.getPassword().contains("2") || user.getPassword().contains("3"))
        );
    }



    public List<User> filter(List<User> users, Predicate<User> p){
        return users.stream()
                .filter(p)
                .collect(Collectors.toList());
    }


    /*@PostMapping("/registration")
    public String registration(@Valid UserDto userDto) throws MessagingException {
        System.out.println("registration");
        System.out.println(userDto.toString());
        if(userService.findByEmail(userDto.getEmail()) != null){
            System.out.println("User already exist");
            return null;
        }else {
            String code = utpGateway.generate();
            userService.save(userDto);
            utpGateway.save(code, userDto.getEmail());
            String message =
                    "<html><body><a href='http://localhost:8080/activate/%s'>Ссылка</a></body></html>".formatted(code);
                    *//*String.format("Hello, %s! \n", userDto.getName()) +
                    "Please, visit next link: \n" +
                    "http://localhost:8080/activate/" + code;*//*
            mailSender.sendHtmlMessage(userDto.getEmail(), "ACTIVATION CODE", message);
        }


        return "registration";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable("code") String code){
        String email = utpGateway.isValid(code);
        if(email == null){
            System.out.println("Activateion code dont actual");
            return null;
        }else {
            userService.activateAccount(email);
        }
        return "login";
    }*/
}