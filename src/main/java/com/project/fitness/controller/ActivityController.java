package com.project.fitness.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;

import com.project.fitness.model.User;

import com.project.fitness.service.ActivityService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    
    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(
          @Valid  @RequestBody ActivityRequest request
    ) {

        return ResponseEntity.ok(
                activityService.trackActivity(request)
        );
    }

    
    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(
            Authentication authentication
    ) {

        User user =
                (User) authentication.getPrincipal();

        return ResponseEntity.ok(
                activityService.getUserActivities(
                        user.getId()
                )
        );
    }
    @PutMapping("/{id}")
public ResponseEntity<ActivityResponse> updateActivity(
        @PathVariable String id,
        @RequestBody ActivityRequest request
) {

    return ResponseEntity.ok(
            activityService.updateActivity(id, request)
    );
}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteActivity(
        @PathVariable String id
) {

    return ResponseEntity.ok(
            activityService.deleteActivity(id)
    );
}
}