package com.example.gainzapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Exercise() {}

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
