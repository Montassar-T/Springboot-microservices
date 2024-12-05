package com.mdw.authentification;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private String secretKey = "your_secret_key"; // Replace with your secret key

    // Generate JWT token
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims) // Add custom claims if any
                .setSubject(subject) // Subject (e.g., username or user ID)
                .setIssuedAt(new Date()) // Issued at timestamp
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Token valid for 1 hour
                .signWith(SignatureAlgorithm.HS256, secretKey) // Sign the token with the secret key
                .compact();
    }

    // Validate JWT token
    public boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    // Extract expiration date from token
    public Date getExpirationDateFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    // Extract username (subject) from token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
