package com.example.gainzapi.controller;

import com.example.gainzapi.dto.LoginDto;
import com.example.gainzapi.dto.SignupDto;
import com.example.gainzapi.model.User;
import com.example.gainzapi.response.LoginResponse;
import com.example.gainzapi.service.AuthenticationService;
import com.example.gainzapi.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupDto signupDto) {
        User newUser = authenticationService.signup(signupDto);

        if(newUser == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        User user = authenticationService.login(loginDto);

        if (user == null) {
            return new ResponseEntity<>(new LoginResponse(
                    "", 0L, "Invalid Credentials"
            ), HttpStatus.UNAUTHORIZED);
        }

        String token = jwtService.generateToken(user.getUsername());

        return ResponseEntity.ok(new LoginResponse(
            token, jwtService.extractExpiration(token).getTime(), "Successfully logged in"
        ));

    }
}
