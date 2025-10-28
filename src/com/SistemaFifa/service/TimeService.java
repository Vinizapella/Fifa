package com.SistemaFifa.service;

import com.SistemaFifa.model.Time;
import java.util.List;
import java.util.Optional;

public interface TimeService {

    Time salvar(Time time) throws Exception;

    List<Time> listarTodos();

    Optional<Time> buscarPorId(Long id);

    void remover(Long id) throws Exception;
}