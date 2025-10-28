package com.SistemaFifa.repository;

import com.SistemaFifa.model.Jogador;
import java.util.List;
import java.util.Optional;

public interface JogadorRepository {

    Jogador salvar(Jogador jogador);

    List<Jogador> listarTodos();

    Optional<Jogador> buscarPorId(Long id);

    void remover(Long id);

    List<Jogador> buscarPorTimeId(Long timeId);
}
