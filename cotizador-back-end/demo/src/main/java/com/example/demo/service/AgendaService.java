package com.example.demo.service;

import java.util.List;
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

    public List<Agenda> obtenerAgendaById(Long idCliente) {
        return agendaRepository.findByIdCliente(idCliente);
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
                cita.setIdCliente(agenda.getIdCliente());
                agendaRepository.save(cita);
            }
        );
    }

    public List<Agenda> obtenerAgendaByStatus(Boolean estatus) {
        return agendaRepository.findByEstatus(estatus);
    }
}
