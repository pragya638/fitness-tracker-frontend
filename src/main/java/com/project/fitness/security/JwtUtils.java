package com.project.fitness.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.project.fitness.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkey12345";

    private static final long JWT_EXPIRATION =
            1000 * 60 * 60 * 24;

    private final SecretKey key =
            Keys.hmacShaKeyFor(
                    SECRET.getBytes()
            );

    // GENERATE TOKEN
    public String generateToken(User user) {

        return Jwts.builder()

                .setSubject(user.getEmail())

                .claim("userId", user.getId())

                .claim("role", user.getRole().name())

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + JWT_EXPIRATION
                        )
                )

                .signWith(
                        key,
                        SignatureAlgorithm.HS256
                )

                .compact();
    }

    // EXTRACT USER ID
    public String extractUserId(String token) {

        return extractAllClaims(token)
                .get("userId", String.class);
    }

    // EXTRACT EMAIL
    public String extractEmail(String token) {

        return extractAllClaims(token)
                .getSubject();
    }

    // VALIDATE TOKEN
    public boolean validateToken(String token) {

        try {

            extractAllClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // EXTRACT CLAIMS
    private Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()

                .setSigningKey(key)

                .build()

                .parseClaimsJws(token)

                .getBody();
    }
}