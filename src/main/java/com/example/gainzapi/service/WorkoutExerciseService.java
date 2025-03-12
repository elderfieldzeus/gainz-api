package com.example.gainzapi.service;

import com.example.gainzapi.dto.workoutexercise.AddWorkoutExerciseDto;
import com.example.gainzapi.dto.workoutexercise.UpdateWorkoutExchangeDto;
import com.example.gainzapi.dto.workoutexercise.WorkoutExerciseResponseDto;
import com.example.gainzapi.model.Exercise;
import com.example.gainzapi.model.Workout;
import com.example.gainzapi.model.WorkoutExercise;
import com.example.gainzapi.repository.ExerciseRepository;
import com.example.gainzapi.repository.WorkoutExerciseRepository;
import com.example.gainzapi.repository.WorkoutRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutExerciseService {
    private final WorkoutExerciseRepository workoutExerciseRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository, WorkoutRepository workoutRepository, ExerciseRepository exerciseRepository) {
        this.workoutExerciseRepository = workoutExerciseRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<WorkoutExerciseResponseDto> findAllByWorkoutId(Long workoutId) {
        List<WorkoutExercise> workoutExercises = workoutExerciseRepository.findAllByWorkoutId(workoutId);
        List<WorkoutExerciseResponseDto> workoutExerciseResponseDtos = new ArrayList<>();

        for (WorkoutExercise workoutExercise : workoutExercises) {
            workoutExerciseResponseDtos.add(new WorkoutExerciseResponseDto(workoutExercise));
        }

        return workoutExerciseResponseDtos;
    }

    public WorkoutExerciseResponseDto addWorkoutExercise(AddWorkoutExerciseDto addWorkoutExerciseDto, Long workoutId) {
        Optional<Workout> workout = workoutRepository.findById(workoutId);
        Optional<Exercise> exercise = exerciseRepository.findById(addWorkoutExerciseDto.getExerciseId());

        if (workout.isEmpty() || exercise.isEmpty()) {
            return null;
        }

        WorkoutExercise workoutExercise = new WorkoutExercise(
                workout.get(),
                exercise.get(),
                addWorkoutExerciseDto.getSets(),
                addWorkoutExerciseDto.getReps(),
                addWorkoutExerciseDto.getWeight()
        );

        workoutExerciseRepository.save(workoutExercise);

        return new WorkoutExerciseResponseDto(workoutExercise);
    }

    public WorkoutExerciseResponseDto updateWorkoutExercise(UpdateWorkoutExchangeDto updateWorkoutExerciseDto, Long workoutExerciseId) {
        Optional<WorkoutExercise> workoutExercise = workoutExerciseRepository.findById(workoutExerciseId);

        if (workoutExercise.isEmpty()) {
            return null;
        }

        WorkoutExercise workoutExercise1 = workoutExercise.get();

        workoutExercise1.setSets(updateWorkoutExerciseDto.getSets());
        workoutExercise1.setReps(updateWorkoutExerciseDto.getReps());
        workoutExercise1.setWeight(updateWorkoutExerciseDto.getWeight());

        workoutExerciseRepository.save(workoutExercise1);

        return new WorkoutExerciseResponseDto(workoutExercise1);
    }

    public WorkoutExerciseResponseDto deleteWorkoutExercise(Long workoutExerciseId) {
        Optional<WorkoutExercise> workoutExercise = workoutExerciseRepository.findById(workoutExerciseId);

        if (workoutExercise.isEmpty()) {
            return null;
        }

        workoutExerciseRepository.delete(workoutExercise.get());

        return new WorkoutExerciseResponseDto(workoutExercise.get());
    }
}
