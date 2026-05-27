package com.project.fitness.service;

import org.apache.el.stream.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.model.UserRole;
import com.project.fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    
    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
        .email(request.getEmail())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .role(
                request.getRole() != null
                        ? request.getRole()
                        : UserRole.USER
        )
        .passwordHash(
                passwordEncoder.encode(
                        request.getPassword()
                )
        )
        .build();
        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

  
    public UserResponse mapToResponse(User user) {

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPasswordHash());
        response.setFirstName(user.getFirstName());

        response.setLastName(user.getLastName());
         response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return response;
    }

    // FIND USER BY ID
    public User findById(String userId) {

        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with id : " + userId
                        )
                );
    }
    public User authenticate (LoginRequest loginRequest){
        User user=userRepository.findByEmail(loginRequest.getEmail())
        .orElse(null);
                
                if(user==null){
                    throw new RuntimeException("User not found with email : " + loginRequest.getEmail());
                }
                if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())){
                    throw new RuntimeException("Invalid password");
                }
        return user;
    }
}