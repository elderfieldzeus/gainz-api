package com.example.gainzapi.controller;

import com.example.gainzapi.dto.exercise.AddExerciseDto;
import com.example.gainzapi.dto.exercise.ExerciseResponseDto;
import com.example.gainzapi.dto.user.UserResponseDto;
import com.example.gainzapi.repository.UserRepository;
import com.example.gainzapi.service.ExerciseService;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/exercise")
@RestController
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseResponseDto>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseResponseDto> getExerciseById(@PathVariable Long id) {
        ExerciseResponseDto exerciseResponseDto = exerciseService.findById(id);

        if (exerciseResponseDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(exerciseResponseDto);
    }

    @PostMapping
    public ResponseEntity<ExerciseResponseDto> addExercise(@RequestBody AddExerciseDto addExerciseDto) {
        return ResponseEntity.ok(exerciseService.create(addExerciseDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExerciseResponseDto> updateExercise(@RequestBody AddExerciseDto addExerciseDto, @PathVariable Long id) {
        ExerciseResponseDto exerciseResponseDto = exerciseService.update(addExerciseDto, id);

        if (exerciseResponseDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(exerciseResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExerciseResponseDto> deleteExercise(@PathVariable Long id) {
        ExerciseResponseDto exerciseResponseDto = exerciseService.delete(id);

        if (exerciseResponseDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(exerciseResponseDto);
    }
}
