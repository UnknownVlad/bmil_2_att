package com.example.bmil_2_att.repository;




import com.example.bmil_2_att.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    void deleteUserById(long id);
    User findByUsername(String username);
    void deleteUserByUsername(String username);



}
