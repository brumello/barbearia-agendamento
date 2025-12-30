package com.barbearia.controller;

import com.barbearia.entity.Agendamento;
import com.barbearia.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Agendamento> agendar(@RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(service.agendar(agendamento));
    }
}