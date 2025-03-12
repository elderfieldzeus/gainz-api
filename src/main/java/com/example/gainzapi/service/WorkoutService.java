package com.example.gainzapi.service;

import com.example.gainzapi.dto.workout.AddWorkoutDto;
import com.example.gainzapi.dto.workout.UpdateWorkoutDto;
import com.example.gainzapi.dto.workout.WorkoutResponseDto;
import com.example.gainzapi.model.User;
import com.example.gainzapi.model.Workout;
import com.example.gainzapi.repository.UserRepository;
import com.example.gainzapi.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private final UserRepository userRepository;
    private final WorkoutRepository workoutRepository;

    public WorkoutService(UserRepository userRepository, WorkoutRepository workoutRepository) {
        this.userRepository = userRepository;
        this.workoutRepository = workoutRepository;
    }

    public List<WorkoutResponseDto> findAll() {
        List<Workout> workouts = workoutRepository.findAll();
        List<WorkoutResponseDto> workoutResponseDtos = new ArrayList<>();

        for (Workout workout : workouts) {
            workoutResponseDtos.add(new WorkoutResponseDto(workout));
        }

        return workoutResponseDtos;
    }

    public WorkoutResponseDto findById(Long id) {
        Optional<Workout> workout = workoutRepository.findById(id);

        if (workout.isEmpty()) {
            return null;
        }

        return new WorkoutResponseDto(workout.get());
    }

    public WorkoutResponseDto create(AddWorkoutDto addWorkoutDto) {
        Optional<User> user = userRepository.findById(addWorkoutDto.getUserId());

        if (user.isEmpty()) {
            return null;
        }

        Workout workout = new Workout(
                user.get(),
                addWorkoutDto.getTitle(),
                addWorkoutDto.getDescription()
        );

        workoutRepository.save(workout);

        return new WorkoutResponseDto(workout);
    }

    public List<WorkoutResponseDto> findByUserId(Long userId) {
        List<Workout> workout = workoutRepository.findByUserId(userId);
        List<WorkoutResponseDto> workoutResponseDtos = new ArrayList<>();

        for (Workout workout1 : workout) {
            workoutResponseDtos.add(new WorkoutResponseDto(workout1));
        }

        return workoutResponseDtos;
    }

    public WorkoutResponseDto update(Long id, UpdateWorkoutDto updateWorkoutDto) {
        Optional<Workout> workout = workoutRepository.findById(id);

        if (workout.isEmpty()) {
            return null;
        }

        Workout _workout = workout.get();

        _workout.setTitle(updateWorkoutDto.getTitle());
        _workout.setDescription(updateWorkoutDto.getDescription());

        workoutRepository.save(_workout);

        return new WorkoutResponseDto(_workout);
    }

    public WorkoutResponseDto delete(Long id) {
        Optional<Workout> workout = workoutRepository.findById(id);

        if (workout.isEmpty()) {
            return null;
        }

        Workout _workout = workout.get();
        workoutRepository.delete(_workout);

        return new WorkoutResponseDto(_workout);
    }
}
