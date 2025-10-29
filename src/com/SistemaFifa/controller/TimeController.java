package com.SistemaFifa.controller;


import com.SistemaFifa.model.Time;
import com.SistemaFifa.service.JogadorService;
import com.SistemaFifa.service.TimeService;
import com.SistemaFifa.view.AppView;

import java.util.Optional;

public class TimeController {

    private final AppView view;
    private final TimeService timeService;
    private final JogadorService jogadorService;

    public TimeController(AppView view, TimeService timeService, JogadorService jogadorService) {
        this.view = view;
        this.timeService = timeService;
        this.jogadorService = jogadorService;
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            int opcao = view.mostrarMenuTimes();
            switch (opcao) {
                case 1: listarTimes(); break;
                case 2: adicionarTime(); break;
                case 3: atualizarTime(); break;
                case 4: removerTime(); break;
                case 5: listarJogadoresDeUmTime(); break;
                case 0:
                    rodando = false;
                    break;
                default:
                    view.mostrarMensagem("Opção inválida.");
            }
            if (rodando) view.aguardarEnter();
        }
    }

    private void listarTimes() {
        view.mostrarListaTimes(timeService.listarTodos());
    }

    private void adicionarTime() {
        Time time = view.lerNovoTime();
        try {
            timeService.salvar(time);
            view.mostrarMensagem("Time '" + time.getNome() + "' salvo com ID " + time.getId());
        } catch (Exception e) {
            view.mostrarMensagem("Erro: " + e.getMessage());
        }
    }

    private void atualizarTime() {
        Long id = view.lerId("time para atualizar");
        if(id == null) {
            view.mostrarMensagem("ID inválido.");
            return;
        }

        Optional<Time> timeOpt = timeService.buscarPorId(id);
        if (!timeOpt.isPresent()) {
            view.mostrarMensagem("Time não encontrado.");
            return;
        }

        Time time = timeOpt.get();
        Time novosDados = view.lerNovoTime();

        time.setNome(novosDados.getNome());
        time.setCidade(novosDados.getCidade());

        try {
            timeService.salvar(time);
            view.mostrarMensagem("Time atualizado com sucesso.");
        } catch (Exception e) {
            view.mostrarMensagem("Erro: " + e.getMessage());
        }
    }

    private void removerTime() {
        Long id = view.lerId("time para remover");
        if(id == null) {
            view.mostrarMensagem("ID inválido.");
            return;
        }

        try {
            timeService.remover(id);
            view.mostrarMensagem("Time removido com sucesso.");
        } catch (Exception e) {
            view.mostrarMensagem("Erro ao remover: " + e.getMessage());
        }
    }

    private void listarJogadoresDeUmTime() {
        Long id = view.lerId("time");
        if(id == null) {
            view.mostrarMensagem("ID inválido.");
            return; }

        if (!timeService.buscarPorId(id).isPresent()) {
            view.mostrarMensagem("Time não encontrado.");
            return;
        }

        view.mostrarListaJogadores(jogadorService.listarJogadoresPorTime(id));
    }
}