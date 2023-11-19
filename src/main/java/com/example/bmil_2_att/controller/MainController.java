package com.example.bmil_2_att.controller;



import com.example.bmil_2_att.model.User;
import com.example.bmil_2_att.model.UserDTO;
import com.example.bmil_2_att.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(
                userService.findAll()
        );
    }

    @PostMapping( "/reg")
    public ResponseEntity<String> registrationUser(@RequestBody  UserDTO userDTO){
        userService.save(userDTO);
        return ResponseEntity.ok(
                "app"
        );

    }

    @GetMapping("/filter9")
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