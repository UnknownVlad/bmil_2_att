package com.example.bmil_2_att;

import com.example.bmil_2_att.model.UserDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bmil2AttApplication {

    public static void main(String[] args) {
        System.out.println(
            new UserDTO(
                    "User",
                    "password",
                    new double[]{0.1 , 0.2, 0.3},
                    new double[]{0.1 , 0.2, 0.3}
            )
        );
        SpringApplication.run(Bmil2AttApplication.class, args);
    }

}
