package com.SistemaFifa.service;

import com.SistemaFifa.model.Jogador;
import java.util.List;
import java.util.Optional;

public interface JogadorService {

    Jogador salvar(Jogador jogador) throws Exception;

    List<Jogador> listarTodos();

    Optional<Jogador> buscarPorId(Long id);

    void remover(Long id) throws Exception;

    Jogador contratarJogador(Long jogadorId, Long timeId) throws Exception;

    Jogador demitirJogador(Long jogadorId) throws Exception;

    List<Jogador> listarJogadoresPorTime(Long timeId);
}