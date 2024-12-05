package com.mdw.authentification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth/")
public class AdminController {

    private final String login = "admin"; // Hardcoded login
    private final String password = "admin123"; // Hardcoded password

    private JwtUtil jwtUtil = new JwtUtil(); // JWT Utility class

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin loginAdmin) {
        Map<String, String> response = new HashMap<>();

        if (login.equals(loginAdmin.getLogin()) && password.equals(loginAdmin.getPassword())) {
            // If credentials match, generate a JWT token
            Map<String, Object> claims = new HashMap<>();
            String token = jwtUtil.generateToken(claims, loginAdmin.getLogin()); // Use loginAdmin.getLogin() as the subject

            response.put("message", "Login successful");
            response.put("token", token);  // Return JWT token
            return ResponseEntity.ok(response);
        } else {
            // If invalid credentials, return error message
            response.put("message", "Invalid login or password");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
