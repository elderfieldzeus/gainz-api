package com.example.gainzapi.service;

import com.example.gainzapi.dto.SignupDto;
import com.example.gainzapi.model.User;
import com.example.gainzapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(SignupDto signupDto) {
        Optional<User> checkUser = userRepository.findByUsername(signupDto.getUsername());

        if (checkUser.isEmpty()) {
            return null;
        }

        User user = new User(signupDto.getUsername(), passwordEncoder.encode(signupDto.getPassword()));
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        Optional<User> checkUser = userRepository.findByUsername(username);

        if (checkUser.isEmpty()) {
            return null;
        }

        User user = checkUser.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }

        return user;
    }
}
