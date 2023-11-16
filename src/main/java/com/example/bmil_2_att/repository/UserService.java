package com.example.bmil_2_att.repository;



import com.example.bmil_2_att.model.User;
import com.example.bmil_2_att.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean save(UserDTO user) {
        userRepository.save(
                new User(
                        user.getUsername(),
                        user.getRetentionTime(),
                        user.getDelayTime()
                )
        );
        return true;
    }

}
