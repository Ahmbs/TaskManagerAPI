package com.example.TaskManagerAPI.controller;

import com.example.TaskManagerAPI.dto.LoginRequestDTO;
import com.example.TaskManagerAPI.Infra.security.TokenService;
import com.example.TaskManagerAPI.dto.LoginRequestDTO;
import com.example.TaskManagerAPI.dto.RegisterRequestDTO;
import com.example.TaskManagerAPI.dto.ResponseDTO;
import com.example.TaskManagerAPI.model.User;
import com.example.TaskManagerAPI.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO request) {
        User user = this.userRepository.findByUsername(request.username()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(request.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().body(new ResponseDTO("Wrong password",null));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO request) {
        Optional<User> user = this.userRepository.findByUsername(request.username());
        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setUsername(request.username());
            newUser.setPassword(passwordEncoder.encode(request.password()));
            newUser.setRole("USER");
            this.userRepository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getUsername(), token));
        }

        return ResponseEntity.badRequest().body(new ResponseDTO("Username already exists", null));
    }
}
