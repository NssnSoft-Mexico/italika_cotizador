package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Agenda;
import com.example.demo.repository.AgendaRepository;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> obtenerAgenda() {
        return agendaRepository.findAll();
    }

    public Agenda obtenerAgendaById(Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        return agenda.orElse(null);
    }

    public Agenda saveAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public void deleteCita(Long id) {
        agendaRepository.deleteById(id);
    }

    public void actualizarCita(Agenda agenda) {
        agendaRepository.findById(agenda.getId())
            .ifPresent(cita -> {
                cita.setEstatus(agenda.getEstatus());
                cita.setId_cliente(agenda.getId_cliente());
                agendaRepository.save(cita);
            }
        );
    }

    public List<Agenda> obtenerAgendaByStatus(Boolean estatus) {
        return agendaRepository.findByEstatus(estatus);
    }
}
