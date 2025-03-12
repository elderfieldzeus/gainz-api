package com.example.gainzapi.dto.workout;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddWorkoutDto {
    public String title;
    public String description;
    public Long userId;
}
