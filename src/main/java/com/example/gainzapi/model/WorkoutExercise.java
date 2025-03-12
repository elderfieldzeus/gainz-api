package com.example.gainzapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workout_exercise")
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_workout_workout_exercise"))
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_exercise_workout_exercise"))
    private Exercise exercise;

    @Column(nullable = false)
    private Integer sets;

    @Column(nullable = false)
    private Integer reps;

    @Column(nullable = true)
    private Float weight;

    public WorkoutExercise() {}

    public WorkoutExercise(Workout workout, Exercise exercise, Integer sets, Integer reps, Float weight) {
        this.workout = workout;
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }
}
