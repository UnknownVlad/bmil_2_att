package com.example.bmil_2_att.registration.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private double[] retentionTime;
    private double[] delayTime;

    public User(String username, String password, double[] retentionTime, double[] delayTime) {
        this.username = username;
        this.password = password;
        this.retentionTime = retentionTime;
        this.delayTime = delayTime;
    }
}
