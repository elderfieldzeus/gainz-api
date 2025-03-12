package com.example.gainzapi.controller;

import com.example.gainzapi.dto.workout.AddWorkoutDto;
import com.example.gainzapi.dto.workout.UpdateWorkoutDto;
import com.example.gainzapi.dto.workout.WorkoutResponseDto;
import com.example.gainzapi.model.Workout;
import com.example.gainzapi.service.WorkoutService;
import org.hibernate.jdbc.Work;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/workout")
@RestController
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<WorkoutResponseDto>> getAllWorkouts() {
        return ResponseEntity.ok(workoutService.findAll());
    }

    @PostMapping
    public ResponseEntity<WorkoutResponseDto> addWorkout(@RequestBody AddWorkoutDto addWorkoutDto) {
        WorkoutResponseDto workoutResponseDto = workoutService.create(addWorkoutDto);

        if (workoutResponseDto == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(workoutResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutResponseDto> getWorkoutById(@PathVariable Integer id) {
        WorkoutResponseDto workoutResponseDto = workoutService.findById(Long.valueOf(id));

        if (workoutResponseDto == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(workoutResponseDto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<WorkoutResponseDto>> getWorkoutByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(workoutService.findByUserId(Long.valueOf(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WorkoutResponseDto> updateUserById(@PathVariable Integer id, @RequestBody UpdateWorkoutDto updateWorkoutDto) {
        WorkoutResponseDto workoutResponseDto = workoutService.update(Long.valueOf(id), updateWorkoutDto);

        if (workoutResponseDto == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(workoutResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkoutResponseDto> deleteWorkoutById(@PathVariable Integer id) {
        WorkoutResponseDto workoutResponseDto = workoutService.delete(Long.valueOf(id));

        if (workoutResponseDto == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(workoutResponseDto);
    }
}
