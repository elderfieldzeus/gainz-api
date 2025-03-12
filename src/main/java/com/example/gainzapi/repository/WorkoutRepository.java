package com.example.gainzapi.repository;

import com.example.gainzapi.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    public List<Workout> findByUserId(Long userId);
}
