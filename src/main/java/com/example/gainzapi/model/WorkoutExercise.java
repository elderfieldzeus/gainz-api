package com.example.gainzapi.model;

import jakarta.persistence.*;

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
    private int sets;

    @Column(nullable = false)
    private int reps;

    @Column(nullable = true)
    private int weight;
}
