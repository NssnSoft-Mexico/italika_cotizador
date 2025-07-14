package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ordenes;
import com.example.demo.service.OrdenesService;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenesController {
    @Autowired
    private OrdenesService ordenesService;

    @GetMapping
    public List<Ordenes> obtenerOrdenes() {
        return ordenesService.obtenerOrdenes();
    }

    @PostMapping
    public Ordenes crearOrden(@RequestBody Ordenes ordenes) {
        return ordenesService.saveOrdenes(ordenes);
    }

}
