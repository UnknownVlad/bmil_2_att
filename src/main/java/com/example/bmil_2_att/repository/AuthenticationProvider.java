package com.example.bmil_2_att.repository;

import com.example.bmil_2_att.custom_exeption.exeptions.NotEqPasswordException;
import com.example.bmil_2_att.custom_exeption.exeptions.UserNotExistException;
import com.example.bmil_2_att.registration.model.User;
import com.example.bmil_2_att.registration.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthenticationProvider {
    @Autowired
    private UserService userService;

    private final Double SIMILARITY = 0.2;

    public User loadUser(String username, String password){
        User user = userService.findByUsername(username);

        if (user == null){
            throw new UserNotExistException("user doesn't exist");
        }else if (!user.getPassword().equals(password)){
            throw new NotEqPasswordException("the wrong password");
        }

        return user;
    }


    public boolean isMatchUser(User user, User received){
        double m1 = (double) Arrays.stream(user.getBetweenTaps()).sum() / user.getBetweenTaps().length;
        double m2 = (double) Arrays.stream(received.getBetweenTaps()).sum() / received.getBetweenTaps().length;

        double diff = Math.abs(m1 - m2);
        double similarity = diff / m2;

        return similarity <= SIMILARITY;
    }


}
