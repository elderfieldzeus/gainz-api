package com.example.gainzapi.dto.exercise;

import com.example.gainzapi.model.Exercise;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseResponseDto {
    private Long id;
    private String name;
    private String description;

    public ExerciseResponseDto(Exercise exercise) {
        this.id = exercise.getId();
        this.name = exercise.getName();
        this.description = exercise.getDescription();
    }
}
