package com.example.gainzapi.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String token;
    private Long expiration;
    private String message;

    public LoginResponseDto(String token, Long expiration, String message) {
        this.token = token;
        this.expiration = expiration;
        this.message = message;
    }
}
