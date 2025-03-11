package com.example.gainzapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    private String username;
    private String password;

    public SignupDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
