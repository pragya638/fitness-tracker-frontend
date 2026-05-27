package com.project.fitness.dto;

import java.time.LocalDateTime;

import com.project.fitness.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
     private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
