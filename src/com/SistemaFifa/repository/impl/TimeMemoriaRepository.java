package com.SistemaFifa.repository.impl;

import com.SistemaFifa.model.Time;
import com.SistemaFifa.repository.TimeRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TimeMemoriaRepository implements TimeRepository {
    private final Map<Long, Time> bancoTimes = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public Time salvar(Time time) {
        if (time.getId() == null) {
            time.setId(sequence.getAndIncrement());
        }
        bancoTimes.put(time.getId(), time);
        return time;
    }

    @Override
    public List<Time> listarTodos() {

        return new ArrayList<>(bancoTimes.values());
    }

    @Override
    public Optional<Time> buscarPorId(Long id) {

        return Optional.ofNullable(bancoTimes.get(id));
    }

    @Override
    public void remover(Long id) {

        bancoTimes.remove(id);
    }
}
