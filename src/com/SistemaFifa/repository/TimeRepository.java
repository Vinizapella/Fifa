package com.SistemaFifa.repository;

import com.SistemaFifa.model.Time;
import java.util.List;
import java.util.Optional;

public interface TimeRepository {

    Time salvar(Time time);

    List<Time> listarTodos();

    Optional<Time> buscarPorId(Long id);

    void remover(Long id);
}
