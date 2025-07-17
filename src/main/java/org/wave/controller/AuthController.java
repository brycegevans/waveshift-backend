package org.wave.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wave.request.LoginRequest;
import org.wave.request.RegisterRequest;
import org.wave.response.LoginResponse;
import org.wave.response.RegisterResponse;
import org.wave.service.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AuthController(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request){
        LoginResponse response = authService.checkLogin(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest request){
        RegisterResponse response = authService.registerUser(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/account")
    public ResponseEntity<RegisterResponse> getCurrentUser(@RequestHeader("Authorization") String header){
        RegisterResponse response = authService.checkCurrentUser(header);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/test/hash")
    public String hashPassword() {
        return passwordEncoder.encode("testpassword");
    }

}
