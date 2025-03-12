package com.example.gainzapi.dto.workoutexercise;


import com.example.gainzapi.dto.exercise.ExerciseResponseDto;
import com.example.gainzapi.dto.workout.WorkoutResponseDto;
import com.example.gainzapi.model.Workout;
import com.example.gainzapi.model.WorkoutExercise;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutExerciseResponseDto {
    private Long id;
    private ExerciseResponseDto exercise;
    private Long workoutId;
    private Integer sets;
    private Integer reps;
    private Float weight;

    public WorkoutExerciseResponseDto(WorkoutExercise workoutExercise) {
        this.id = workoutExercise.getId();
        this.exercise = new ExerciseResponseDto(workoutExercise.getExercise());
        this.workoutId = workoutExercise.getWorkout().getId();
        this.sets = workoutExercise.getSets();
        this.reps = workoutExercise.getReps();
        this.weight = workoutExercise.getWeight();
    }
}
