package com.example.bmil_2_att.custom_exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String message;
    private Integer status;

    public String toJson() {
        return "{\"message\":\"" + message + "\",\"status\":" + status + "}";
    }
}
