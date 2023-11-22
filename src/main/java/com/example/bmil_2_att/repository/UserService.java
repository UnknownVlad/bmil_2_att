package com.example.bmil_2_att.repository;



import com.example.bmil_2_att.model.User;
import com.example.bmil_2_att.model.UserDTO;
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

    public boolean save(UserDTO user) {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }

        userRepository.save(
                new User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getRetentionTime(),
                        user.getDelayTime()
                )
        );
        return true;

    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteByUsername(String username) {
        userRepository.deleteUserByUsername(username);
    }
}
