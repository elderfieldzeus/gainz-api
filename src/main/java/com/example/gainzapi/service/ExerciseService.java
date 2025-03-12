package com.example.gainzapi.service;

import com.example.gainzapi.dto.exercise.AddExerciseDto;
import com.example.gainzapi.dto.exercise.ExerciseResponseDto;
import com.example.gainzapi.model.Exercise;
import com.example.gainzapi.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExerciseResponseDto> findAll() {
        List<Exercise> exercises = exerciseRepository.findAll();
        List<ExerciseResponseDto> exerciseResponseDtos = new ArrayList<>();

        for (Exercise exercise : exercises) {
            exerciseResponseDtos.add(new ExerciseResponseDto(exercise));
        }

        return exerciseResponseDtos;
    }

    public ExerciseResponseDto findById(Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);

        if (exercise.isEmpty()) {
            return null;
        }

        return new ExerciseResponseDto(exercise.get());
    }

    public ExerciseResponseDto create(AddExerciseDto addExerciseDto) {
        Exercise exercise = new Exercise(
                addExerciseDto.getName(),
                addExerciseDto.getDescription()
        );

        exerciseRepository.save(exercise);

        return new ExerciseResponseDto(exercise);
    }

    public ExerciseResponseDto update(AddExerciseDto addExerciseDto, Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);

        if (exercise.isEmpty()) {
            return null;
        }

        Exercise newExercise = exercise.get();

        newExercise.setName(addExerciseDto.getName());
        newExercise.setDescription(addExerciseDto.getDescription());

        exerciseRepository.save(newExercise);

        return new ExerciseResponseDto(newExercise);
    }

    public ExerciseResponseDto delete(Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);

        if (exercise.isEmpty()) {
            return null;
        }

        Exercise exerciseToDelete = exercise.get();

        exerciseRepository.delete(exerciseToDelete);

        return new ExerciseResponseDto(exerciseToDelete);
    }
}
