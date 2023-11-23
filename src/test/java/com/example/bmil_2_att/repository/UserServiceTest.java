package com.example.bmil_2_att.repository;

import com.example.bmil_2_att.registration.model.User;
import com.example.bmil_2_att.registration.model.UserDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void save() {
        UserDTO user = new UserDTO();

        boolean isSaved = userService.save(user);

        Assert.assertTrue(isSaved);
//        Assert.assertNotNull(user.getRetentionTime());
//        Assert.assertNotNull(user.getDelayTime());
    }

    @Test
    void saveUserFailTest() {
        UserDTO user = new UserDTO();

        user.setUsername("Vlad");
        Mockito.doReturn(new User())
                .when(userRepository)
                .findByUsername("Vlad");
        boolean isSaved = userService.save(user);

        Assert.assertFalse(isSaved);
    }

    @Test
    void findByUsername() {
        User user = new User();

        user.setUsername("Kristina");
        Mockito.doReturn(user)
                .when(userRepository)
                .findByUsername("Kristina");

        Assert.assertEquals(user.getUsername(), userService.findByUsername("Kristina").getUsername());
    }

    @Test
    void findByUsernameFail() {
        User user = new User();

        user.setUsername("Vlad");
        Mockito.doReturn(null)
                .when(userRepository)
                .findByUsername("Kristina");

        Assert.assertNull(userService.findByUsername("Kristina"));
    }

    @Test
    void deleteByUsername() {
        User user = new User();

        user.setUsername("Alexey");
        userService.deleteByUsername("Alexey"); // функция void
        Mockito.doReturn(null)
                .when(userRepository)
                .findByUsername("Alexey");

        Assert.assertNull(userService.findByUsername("Alexey"));
    }
}