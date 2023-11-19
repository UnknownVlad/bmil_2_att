package com.example.bmil_2_att.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private double[] retentionTime;
    @NonNull
    private double[] delayTime;
}
