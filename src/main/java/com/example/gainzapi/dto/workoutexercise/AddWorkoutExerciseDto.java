package com.example.gainzapi.dto.workoutexercise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddWorkoutExerciseDto {
    private Long exerciseId;
    private Integer sets;
    private Integer reps;
    private Float weight;
}
