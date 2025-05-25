package com.enaa.eventbookingapi.controller;


import com.enaa.eventbookingapi.Model.Role;
import com.enaa.eventbookingapi.Model.User;
import com.enaa.eventbookingapi.service.JwtService;
import com.enaa.eventbookingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user.getName(), user.getPassword(), Role.CLIENT); // Default to CLIENT
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User authenticatedUser = userService.authenticate(user.getName(), user.getPassword());
        if (authenticatedUser != null) {
            String token = jwtService.generateToken(user.getName(), authenticatedUser.getRole());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}