package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ordenes;
import com.example.demo.repository.OrdenesRepository;

@Service
public class OrdenesService {
    @Autowired
    private OrdenesRepository ordenesRepository;

    public List<Ordenes> obtenerOrdenes() {
        return ordenesRepository.findAll();
    }

    public Ordenes saveOrdenes(Ordenes ordenes) {
        return ordenesRepository.save(ordenes);
    }
}
