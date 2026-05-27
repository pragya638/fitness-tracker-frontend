package com.project.fitness.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.project.fitness.model.ActivityType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {

    @NotNull(message = "Activity type is required")
    private ActivityType type;

    private Map<String, Object> additionalMetrics;

    @NotNull(message = "Duration is required")
    @Positive(message = "Duration must be positive")
    private Integer duration;

    @NotNull(message = "Calories burned is required")
    @Positive(message = "Calories burned must be positive")
    private Integer caloriesBurned;

    private LocalDateTime startTime;
}