package com.example.gainzapi.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private Long expiration;
    private String message;

    public LoginResponse(String token, Long expiration, String message) {
        this.token = token;
        this.expiration = expiration;
        this.message = message;
    }
}
