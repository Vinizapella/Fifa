package com.SistemaFifa.service.impl;

import com.SistemaFifa.model.Time;
import com.SistemaFifa.repository.JogadorRepository;
import com.SistemaFifa.repository.TimeRepository;
import com.SistemaFifa.service.TimeService;

import java.util.List;
import java.util.Optional;

public class TimeServiceImpl implements TimeService {

    private final TimeRepository timeRepository;
    private final JogadorRepository jogadorRepository;

    public TimeServiceImpl(TimeRepository timeRepository, JogadorRepository jogadorRepository) {
        this.timeRepository = timeRepository;
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public Time salvar(Time time) throws Exception {
        if (time.getNome() == null || time.getNome().trim().isEmpty()) {
            throw new Exception("Nome do time é obrigatório.");
        }
        return timeRepository.salvar(time);
    }

    @Override
    public List<Time> listarTodos() {

        return timeRepository.listarTodos();
    }

    @Override
    public Optional<Time> buscarPorId(Long id) {

        return timeRepository.buscarPorId(id);
    }

    @Override
    public void remover(Long id) throws Exception {
        if (!jogadorRepository.buscarPorTimeId(id).isEmpty()) {
            throw new Exception("Não é possível remover um time que possui jogadores.");
        }
        timeRepository.remover(id);
    }
}