package com.project.fitness.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    private final UserRepository userRepository;

    // CREATE ACTIVITY
    public ActivityResponse trackActivity(
            ActivityRequest request,
            String userId
    ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        )
                );

        Activity activity = Activity.builder()

                .user(user)

                .type(request.getType())

                .duration(request.getDuration())

                .caloriesBurned(
                        request.getCaloriesBurned()
                )

                .startTime(request.getStartTime())

                .additionalMetrics(
                        request.getAdditionalMetrics()
                )

                .build();

        Activity savedActivity =
                activityRepository.save(activity);

        return mapToResponse(savedActivity);
    }

    // MAP ENTITY TO RESPONSE DTO
    public ActivityResponse mapToResponse(
            Activity activity
    ) {

        ActivityResponse response =
                new ActivityResponse();

        response.setId(activity.getId());

        response.setUserId(
                activity.getUser().getId()
        );

        response.setType(activity.getType());

        response.setDuration(
                activity.getDuration()
        );

        response.setCaloriesBurned(
                activity.getCaloriesBurned()
        );

        response.setStartTime(
                activity.getStartTime()
        );

        response.setAdditionalMetrics(
                activity.getAdditionalMetrics()
        );

        response.setCreatedAt(
                activity.getCreatedAt()
        );

        response.setUpdatedAt(
                activity.getUpdatedAt()
        );

        return response;
    }

    // GET ALL USER ACTIVITIES
    public List<ActivityResponse> getUserActivities(
            String userId
    ) {

        userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        )
                );

        List<Activity> activities =
                activityRepository.findByUserId(userId);

        return activities.stream()

                .map(this::mapToResponse)

                .collect(Collectors.toList());
    }

    // GET ACTIVITY BY ID
    public ActivityResponse findById(
            String activityId
    ) {

        Activity activity =
                activityRepository.findById(activityId)

                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Activity not found"
                                )
                        );

        return mapToResponse(activity);
    }

    // UPDATE ACTIVITY
    public ActivityResponse updateActivity(
            String activityId,
            ActivityRequest request
    ) {

        Activity activity =
                activityRepository.findById(activityId)

                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Activity not found"
                                )
                        );

        activity.setType(request.getType());

        activity.setDuration(
                request.getDuration()
        );

        activity.setCaloriesBurned(
                request.getCaloriesBurned()
        );

        activity.setStartTime(
                request.getStartTime()
        );

        activity.setAdditionalMetrics(
                request.getAdditionalMetrics()
        );

        Activity updatedActivity =
                activityRepository.save(activity);

        return mapToResponse(updatedActivity);
    }

    // DELETE ACTIVITY
    public String deleteActivity(
            String activityId
    ) {

        Activity activity =
                activityRepository.findById(activityId)

                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Activity not found"
                                )
                        );

        activityRepository.delete(activity);

        return "Activity deleted successfully";
    }
}