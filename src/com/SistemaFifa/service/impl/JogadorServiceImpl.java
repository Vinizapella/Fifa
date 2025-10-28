package com.SistemaFifa.service.impl;

import com.SistemaFifa.model.Jogador;
import com.SistemaFifa.model.Time;
import com.SistemaFifa.repository.JogadorRepository;
import com.SistemaFifa.repository.TimeRepository;
import com.SistemaFifa.service.JogadorService;

import java.util.List;
import java.util.Optional;

public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;
    private final TimeRepository timeRepository;

    public JogadorServiceImpl(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    @Override
    public Jogador salvar(Jogador jogador) throws Exception {
        if (jogador.getNome() == null || jogador.getNome().trim().isEmpty()) {
            throw new Exception("Nome do jogador é obrigatório.");
        }
        return jogadorRepository.salvar(jogador);
    }

    @Override
    public List<Jogador> listarTodos() {
        return jogadorRepository.listarTodos();
    }

    @Override
    public Optional<Jogador> buscarPorId(Long id) {
        return jogadorRepository.buscarPorId(id);
    }

    @Override
    public void remover(Long id) throws Exception {
        if (!jogadorRepository.buscarPorId(id).isPresent()) {
            throw new Exception("Jogador não encontrado.");
        }
        jogadorRepository.remover(id);
    }

    @Override
    public Jogador contratarJogador(Long jogadorId, Long timeId) throws Exception {
        Optional<Time> timeOpt = timeRepository.buscarPorId(timeId);
        if (!timeOpt.isPresent()) {
            throw new Exception("Time com ID " + timeId + " não encontrado.");
        }

        Optional<Jogador> jogadorOpt = jogadorRepository.buscarPorId(jogadorId);
        if (!jogadorOpt.isPresent()) {
            throw new Exception("Jogador com ID " + jogadorId + " não encontrado.");
        }

        Jogador jogador = jogadorOpt.get();

        if (jogador.getTimeId() != null) {
            throw new Exception("Jogador " + jogador.getNome() + " já pertence a outro time.");
        }

        jogador.setTimeId(timeId);
        return jogadorRepository.salvar(jogador);
    }

    @Override
    public Jogador demitirJogador(Long jogadorId) throws Exception {
        Optional<Jogador> jogadorOpt = jogadorRepository.buscarPorId(jogadorId);
        if (!jogadorOpt.isPresent()) {
            throw new Exception("Jogador com ID " + jogadorId + " não encontrado.");
        }
        Jogador jogador = jogadorOpt.get();
        jogador.setTimeId(null);
        return jogadorRepository.salvar(jogador);
    }

    @Override
    public List<Jogador> listarJogadoresPorTime(Long timeId) {
        return jogadorRepository.buscarPorTimeId(timeId);
    }
}