package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.LoginRequest;
import com.example.demo.repository.LoginRepository;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
    return loginRepository.findByUsername(loginRequest.getUsername())
        .map(user -> {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok("Login exitoso"); // 200 OK
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta"); // 401
            }
        })
        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado")); // 404
    }
}