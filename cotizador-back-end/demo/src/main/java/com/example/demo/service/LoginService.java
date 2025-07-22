package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login saveUser(Login login) {
        return loginRepository.save(login);
    }

    public List<Login> obtenerUsuarios() {
        return loginRepository.findAll();
    }
}