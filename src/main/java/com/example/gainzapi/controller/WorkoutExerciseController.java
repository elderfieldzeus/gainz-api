package com.example.gainzapi.controller;

import com.example.gainzapi.dto.workoutexercise.AddWorkoutExerciseDto;
import com.example.gainzapi.dto.workoutexercise.UpdateWorkoutExchangeDto;
import com.example.gainzapi.dto.workoutexercise.WorkoutExerciseResponseDto;
import com.example.gainzapi.service.WorkoutExerciseService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkoutExerciseController {

    private final WorkoutExerciseService workoutExerciseService;

    public WorkoutExerciseController(WorkoutExerciseService workoutExerciseService) {
        this.workoutExerciseService = workoutExerciseService;
    }

    @GetMapping("/workout/{workoutId}/exercise")
    public ResponseEntity<List<WorkoutExerciseResponseDto>> getWorkoutExercises(@PathVariable Long workoutId) {
        return ResponseEntity.ok(workoutExerciseService.findAllByWorkoutId(workoutId));
    }

    @PostMapping("/workout/{workoutId}/exercise")
    public ResponseEntity<WorkoutExerciseResponseDto> addWorkoutExercise(@RequestBody AddWorkoutExerciseDto addWorkoutExerciseDto, @PathVariable Long workoutId) {
        WorkoutExerciseResponseDto workoutExerciseResponseDto = workoutExerciseService.addWorkoutExercise(addWorkoutExerciseDto, workoutId);

        if (workoutExerciseResponseDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(workoutExerciseResponseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/workout-exercise/{id}")
    public ResponseEntity<WorkoutExerciseResponseDto> updateWorkoutExercise(@RequestBody UpdateWorkoutExchangeDto updateWorkoutExerciseDto, @PathVariable Long id) {
        WorkoutExerciseResponseDto workoutExerciseResponseDto = workoutExerciseService.updateWorkoutExercise(updateWorkoutExerciseDto, id);

        if (workoutExerciseResponseDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(workoutExerciseResponseDto);
    }

    @DeleteMapping("/workout-exercise/{id}")
    public ResponseEntity<WorkoutExerciseResponseDto> deleteWorkoutExercise(@PathVariable Long id) {
        WorkoutExerciseResponseDto workoutExerciseResponseDto = workoutExerciseService.deleteWorkoutExercise(id);

        if (workoutExerciseResponseDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(workoutExerciseResponseDto);
    }
}
