package com.example.bmil_2_att.repository;


import com.example.bmil_2_att.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

}
