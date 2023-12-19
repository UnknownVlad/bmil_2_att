package com.example.bmil_2_att.registration.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    @NonNull
    @Size(min=2)
    private String username;

    @NonNull
    @NotEmpty
    @Size(min=2)
    private String password;

    private String time;

}
