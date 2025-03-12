package com.example.gainzapi.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    private String username;
    private String email;
    private String password;

    public SignupDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
