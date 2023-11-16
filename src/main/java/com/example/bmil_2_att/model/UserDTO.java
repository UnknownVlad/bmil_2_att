package com.example.bmil_2_att.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private String username;
    private String password;
    private double[] retentionTime;
    private double[] delayTime;
}
