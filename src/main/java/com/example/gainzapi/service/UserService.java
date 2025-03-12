package com.example.gainzapi.service;

import com.example.gainzapi.dto.user.UserResponseDto;
import com.example.gainzapi.model.User;
import com.example.gainzapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for (User user : users) {
            userResponseDtos.add(new UserResponseDto(user));
        }

        return userResponseDtos;
    }

    public UserResponseDto findById(Integer id) {
        Optional<User> user = userRepository.findById((Long.valueOf(id)));

        if (user.isEmpty()) {
            return null;
        }

        return new UserResponseDto(user.get());
    }
}
