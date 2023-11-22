package com.example.bmil_2_att.repository;


import com.example.bmil_2_att.registration.model.User;
import com.example.bmil_2_att.registration.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public boolean save(UserDTO user) {
        userRepository.save(
                new User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getBetweenTaps()
                )
        );
        return true;
    }

}
