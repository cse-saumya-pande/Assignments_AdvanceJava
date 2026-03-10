package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.RevokedTokenRepository;
import com.example.demo.model.RevokedToken;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RevokedTokenRepository revokedTokenRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(Role.ROLE_USER);
        }

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent() &&
                passwordEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {

            String token = jwtUtil.generateToken(
                    existingUser.get().getUsername(),
                    existingUser.get().getRole().name()
            );

            return ResponseEntity.ok(Map.of(
            		"accessToken", jwtUtil.generateToken(existingUser.get().getUsername(), existingUser.get().getRole().name()), 
				    "refreshToken", jwtUtil.generateRefreshToken(existingUser.get().getUsername())));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Invalid token format.");
        }
        token = token.substring(7);
        revokedTokenRepository.save(new RevokedToken(token));
        return ResponseEntity.ok("Logged out successfully");
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");

        if (refreshToken == null || jwtUtil.isTokenExpired(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body("Invalid or expired refresh token.");
        }

        String username = jwtUtil.getUsernameFromToken(refreshToken);
        String role = jwtUtil.getRoleFromToken(refreshToken); // ← was passing username here before

        return ResponseEntity.ok(Map.of("accessToken", jwtUtil.generateToken(username, role)));
    }
}