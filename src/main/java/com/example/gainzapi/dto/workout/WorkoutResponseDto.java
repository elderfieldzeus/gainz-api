package com.example.gainzapi.dto.workout;

import com.example.gainzapi.model.Workout;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkoutResponseDto {
    private Long id;
    private String title;
    private String description;
    private Date date;
    private Long userId;

    public WorkoutResponseDto(Workout workout) {
        this.id = workout.getId();
        this.title = workout.getTitle();
        this.description = workout.getDescription();
        this.date = workout.getDate();
        this.userId = workout.getUser().getId();
    }
}
