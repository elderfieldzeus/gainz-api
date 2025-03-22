package com.example.gainzapi.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    Long id;
    String username;
    String email;
    private String token;
    private Long expiration;
    private String message;

    public LoginResponseDto(Long id, String username, String email, String token, Long expiration, String message) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.token = token;
        this.expiration = expiration;
        this.message = message;
    }
}
