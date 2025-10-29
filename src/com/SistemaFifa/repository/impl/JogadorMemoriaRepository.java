package com.SistemaFifa.repository.impl;

import com.SistemaFifa.model.Jogador;
import com.SistemaFifa.repository.JogadorRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class JogadorMemoriaRepository implements JogadorRepository {
    private final Map<Long, Jogador> bancoJogadores = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public Jogador salvar(Jogador jogador) {
        if (jogador.getId() == null) {
            jogador.setId(sequence.getAndIncrement());
        }
        bancoJogadores.put(jogador.getId(), jogador);
        return jogador;
    }

    @Override
    public List<Jogador> listarTodos() {

        return new ArrayList<>(bancoJogadores.values());
    }

    @Override
    public Optional<Jogador> buscarPorId(Long id) {

        return Optional.ofNullable(bancoJogadores.get(id));
    }

    @Override
    public void remover(Long id) {

        bancoJogadores.remove(id);
    }

    @Override
    public List<Jogador> buscarPorTimeId(Long timeId) {
        return bancoJogadores.values().stream().filter(j -> timeId.equals(j.getTimeId())).collect(Collectors.toList());
    }
}