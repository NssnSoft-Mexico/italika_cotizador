package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Agenda;
import com.example.demo.service.AgendaService;

@RestController
@RequestMapping("/api/agenda")
@CrossOrigin(origins = "*")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @GetMapping("/obtenerAgenda")
    public List<Agenda> obtenerAgenda() {
        return agendaService.obtenerAgenda();
    }

    @GetMapping("/obtenerAgendaByStatus/{estatus}")
    public Agenda obtenerAgendaByStatus(@PathVariable Boolean estatus) {
        return agendaService.obtenerAgendaByStatus(estatus);
    }

    @GetMapping("/obtenerAgendaById/{id}")
    public Agenda obtenerAgendaById(@PathVariable Long id) {
        return agendaService.obtenerAgendaById(id);
    }

    @PostMapping("/crearAgenda")
    public Agenda crearAgenda(@RequestBody Agenda agenda) {
        return agendaService.saveAgenda(agenda);
    }

    @PutMapping("/actualizarCita")
    public void actualizarCita(@RequestBody Agenda agenda) {
        agendaService.actualizarCita(agenda);
    }
    
    @DeleteMapping("/borrarCita/{id}")
    public Long borrarCita(@PathVariable Long id) {
        agendaService.deleteCita(id);
        return id;
    }
}
