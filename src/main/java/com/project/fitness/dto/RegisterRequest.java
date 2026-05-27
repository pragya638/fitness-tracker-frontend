package com.project.fitness.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.project.fitness.model.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
   @NotBlank(message = "Email is mandatory")
   @Email(message = "Email should be valid")
   private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    private UserRole role;

}
