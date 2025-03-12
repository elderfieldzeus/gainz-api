package com.example.gainzapi.controller;

import com.example.gainzapi.dto.auth.LoginDto;
import com.example.gainzapi.dto.auth.SignupDto;
import com.example.gainzapi.model.User;
import com.example.gainzapi.dto.auth.LoginResponseDto;
import com.example.gainzapi.service.AuthenticationService;
import com.example.gainzapi.service.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
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
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = authenticationService.login(loginDto);

        if (user == null) {
            return new ResponseEntity<>(new LoginResponseDto(
                    "", 0L, "Invalid Credentials"
            ), HttpStatus.UNAUTHORIZED);
        }

        String token = jwtService.generateToken(user.getUsername());

        Cookie cookie = new Cookie("JWT", token);
        cookie.setPath("/");
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setMaxAge((int)(jwtService.getExpiration() / 1000));

        response.addCookie(cookie);

        return ResponseEntity.ok(new LoginResponseDto(
            token, jwtService.getExpiration(), "Successfully logged in"
        ));

    }
}
