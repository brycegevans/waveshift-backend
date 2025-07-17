package org.wave.service;

import io.jsonwebtoken.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.wave.config.JwtUtil;
import org.wave.model.Role;
import org.wave.model.User;
import org.wave.repo.UserRepository;
import org.wave.request.LoginRequest;
import org.wave.request.RegisterRequest;
import org.wave.response.LoginResponse;
import org.wave.response.RegisterResponse;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class AuthService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepo;
    private JwtUtil jUtil;
    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepo, JwtUtil jUtil){
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.jUtil = jUtil;
    }
    public LoginResponse checkLogin(LoginRequest request){
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        String token = jUtil.generateToken(user);
        return new LoginResponse(
                token,
                user.getEmail(),
                user.getRole().toString(),
                "Login Successful"
        );
    }
    public RegisterResponse registerUser(RegisterRequest request) {
        Optional<User> user = userRepo.findByEmail(request.getEmail());
        if (user.isPresent()) {
            throw new RuntimeException("Email is already in use");
        }
        else{
            User newUser = new User();
            newUser.setEmail(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            newUser.setJoinedAt(LocalDateTime.now());
            newUser.setUpdatedAt(LocalDateTime.now());
            newUser.setFirstName(request.getFirstName());
            newUser.setLastName(request.getLastName());
            newUser.setRole(Role.USER);
            userRepo.save(newUser);
            RegisterResponse response = new RegisterResponse(
                    newUser.getId(),
                    newUser.getEmail(),
                    newUser.getRole().toString(),
                    newUser.getJoinedAt(),
                    newUser.getFirstName(),
                    newUser.getLastName()
            );
            return response;
        }
    }
    public RegisterResponse checkCurrentUser(String header){
        try {
            // Extract token (Assuming "Bearer <token>" format)
            String token = header.substring(7);

            // Validate token
            if (!jUtil.validateToken(token)) {
                throw new RuntimeException("Invalid Token");
            }

            // Extract email from token
            String email = jUtil.extractEmail(token);

            // Find user by email
            Optional<User> userOpt = userRepo.findByEmail(email);
            if (userOpt.isEmpty()) {
                throw new RuntimeException("No User found");
            }

            User user = userOpt.get();

            // Return a DTO or just user details you want to expose (avoid sending password!)
            RegisterResponse responseDto = new RegisterResponse(
                    user.getId(),
                    user.getEmail(),
                    user.getRole().toString(),
                    user.getJoinedAt(),
                    user.getFirstName(),
                    user.getLastName()
            );

            return responseDto;
        } catch (Exception e) {
            throw new RuntimeException("Bad Request");
        }
    }
}
