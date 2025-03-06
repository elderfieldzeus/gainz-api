package com.example.gainzapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }
}
