package com.example.gainzapi.repository;

import com.example.gainzapi.model.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {
    public List<WorkoutExercise> findAllByWorkoutId(Long workoutId);
}
