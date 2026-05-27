package com.project.fitness.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.LoginResponse;
import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.security.JwtUtils;
import com.project.fitness.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
           @Valid @RequestBody RegisterRequest request
    ) {

        return ResponseEntity.ok(
                userService.register(request)
        );
    }

   @PostMapping("/login")
public ResponseEntity<LoginResponse> login(
        @Valid @RequestBody LoginRequest loginRequest
) {

    Optional<User> user = userRepository.findByEmail(
            loginRequest.getEmail()
    );

    if (user.isEmpty()) {

        throw new RuntimeException(
                "Invalid email or password"
        );
    }

    boolean isPasswordCorrect =
            passwordEncoder.matches(
                    loginRequest.getPassword(),
                    user.get().getPasswordHash()
            );

    if (!isPasswordCorrect) {

        throw new RuntimeException(
                "Invalid email or password"
        );
    }

    String token = jwtUtils.generateToken(user.get());

    LoginResponse response =
            new LoginResponse(
                    token,
                    userService.mapToResponse(user.get())
            );

    return ResponseEntity.ok(response);
}
}