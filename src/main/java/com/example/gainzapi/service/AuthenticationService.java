package com.example.gainzapi.service;

import com.example.gainzapi.dto.LoginDto;
import com.example.gainzapi.dto.SignupDto;
import com.example.gainzapi.model.User;
import com.example.gainzapi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(SignupDto signupDto) {
        Optional<User> checkUser = userRepository.findByUsername(signupDto.getUsername());

        if (checkUser.isPresent()) {
            return null;
        }

        User user = new User(signupDto.getUsername(), passwordEncoder.encode(signupDto.getPassword()));
        return userRepository.save(user);
    }

    public User login(LoginDto loginDto) {
        Optional<User> checkUser = userRepository.findByUsername(loginDto.getUsername());

        if (checkUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = checkUser.get();
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return null;
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );

        return user;
    }
}
