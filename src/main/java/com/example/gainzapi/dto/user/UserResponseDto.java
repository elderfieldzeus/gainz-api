package com.example.gainzapi.dto.user;

import com.example.gainzapi.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private boolean enabled;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
    }
}
