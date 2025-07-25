package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Login;
import com.example.demo.model.LoginRequest;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginUser")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return loginRepository.findByUsername(loginRequest.getUsername())
        .map(user -> {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                Map<String, Object> response = new HashMap<>();
                response.put("id", user.getId());
                response.put("direccion", user.getDireccion());
                response.put("nombre_user", user.getNombre_user());
                response.put("tipo", user.getTipo());
                
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta"); // 401
            }
        })
        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado")); // 404
    }

    @PostMapping("/crearUsuario")
    public Login crearUser(@RequestBody Login login) {
        return loginService.saveUser(login);
    }

    @GetMapping("/obtenerUsuarios")
    public List<Login> obtenerUsuarios() {
        return loginService.obtenerUsuarios();
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        if (loginService.eliminarUsuario(id)) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @GetMapping("/obtenerDetailCita/{id}")
    public ResponseEntity<Login> obtenerDetailCita(@PathVariable Long id) {
        return loginRepository.findById(id)
            .map(user -> ResponseEntity.ok(user))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}