package com.project.fitness.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(

            HttpServletRequest request,

            HttpServletResponse response,

            FilterChain filterChain

    ) throws ServletException, IOException {

        final String authHeader =
                request.getHeader("Authorization");

        final String jwt;

        final String userId;

        // CHECK HEADER
        if (authHeader == null
                || !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);

            return;
        }

        // EXTRACT TOKEN
        jwt = authHeader.substring(7);

        // VALIDATE TOKEN
        if (!jwtUtils.validateToken(jwt)) {

            filterChain.doFilter(request, response);

            return;
        }

        // EXTRACT USER ID
        userId = jwtUtils.extractUserId(jwt);

        User user = userRepository
                .findById(userId)
                .orElse(null);

        if (user != null
                && SecurityContextHolder
                .getContext()
                .getAuthentication() == null) {

            java.util.List authorities =
        java.util.List.of(
                new org.springframework.security.core.authority
                        .SimpleGrantedAuthority(
                                "ROLE_" + user.getRole().name()
                        )
        );

UsernamePasswordAuthenticationToken authToken =
        new UsernamePasswordAuthenticationToken(
                user,
                null,
                authorities
        );

            authToken.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request)
            );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}