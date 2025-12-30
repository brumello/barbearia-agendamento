package com.barbearia.service;

import com.barbearia.entity.Agendamento;
import com.barbearia.entity.Agenda;
import com.barbearia.repository.AgendamentoRepository;
import com.barbearia.repository.AgendaRepository;
import org.springframework.stereotype.Service;
import com.barbearia.exception.AgendaFechadaException;
import com.barbearia.exception.AgendaNaoDefinidaException;
import com.barbearia.exception.HorarioOcupadoException;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendaRepository agendaRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, AgendaRepository agendaRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendaRepository = agendaRepository;
    }

    public Agendamento agendar(Agendamento agendamento) {

        if (agendamentoRepository.existsByDataAndHorario(
                agendamento.getData(),
                agendamento.getHorario())) {
            throw new HorarioOcupadoException();
        }

        Agenda agenda = agendaRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(AgendaNaoDefinidaException::new);

        if (agenda.isFechada()) {
            throw new AgendaFechadaException();
        }

        return agendamentoRepository.save(agendamento);
    }
}