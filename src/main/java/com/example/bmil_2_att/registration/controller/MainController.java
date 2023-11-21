package com.example.bmil_2_att.registration.controller;



import com.example.bmil_2_att.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class MainController {

    @Autowired
    private UserService userService;






    /***
     *     public String add(@RequestParam String email,
     *                       @RequestParam String password,
     *                       @RequestParam String name,
     *                       @RequestParam String surname
     *                       ) {
     *
     *        ...
     *     }
     */

    /*@PostMapping("/registration")
    public String registration(UserDto userDto, @RequestParam String action){
        System.out.println(userDto);
        if (action.equals("add")){
            System.out.println("add");
        }else if (action.equals("send")){
            System.out.println("send");
        }

        return "registration";
    }
    */

    @GetMapping("/reg")
    public String registration() {
        return "registration";
    }

    @PostMapping("/reg")
    public String registration(@RequestParam String username, @RequestParam String password)  {
        System.out.println("registration");
        System.out.println(username +"___" +password);


        return "registration";
    }

    /*@PostMapping("/registration")
    public String registration(UserDTO userDto) throws MessagingException {
        System.out.println("registration");
        System.out.println(userDto.toString());
        userService.save(userDto);


        return "registration";
    }*/



}