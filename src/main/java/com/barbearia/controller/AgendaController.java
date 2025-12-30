package com.barbearia.controller;

import com.barbearia.entity.Agenda;
import com.barbearia.repository.AgendaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaRepository repository;

    public AgendaController(AgendaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Agenda criarAgenda(@RequestBody Agenda agenda) {
        return repository.save(agenda);
    }

    @PutMapping("/fechar/{id}")
    public Agenda fecharAgenda(@PathVariable Long id) {
        Agenda agenda = repository.findById(id).orElseThrow();
        agenda.setFechada(true);
        return repository.save(agenda);
    }
}