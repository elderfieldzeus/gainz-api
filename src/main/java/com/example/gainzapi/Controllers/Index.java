package com.example.gainzapi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
