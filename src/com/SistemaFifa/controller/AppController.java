package com.SistemaFifa.controller;

import com.SistemaFifa.model.Jogador;
import com.SistemaFifa.model.Time;
import com.SistemaFifa.service.JogadorService;
import com.SistemaFifa.service.TimeService;
import com.SistemaFifa.view.AppView;

import java.util.Optional;

public class AppController {

    private final AppView view;
    private final TimeService timeService;
    private final JogadorService jogadorService;

    public AppController(AppView view, TimeService timeService, JogadorService jogadorService) {
        this.view = view;
        this.timeService = timeService;
        this.jogadorService = jogadorService;
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            int opcao = view.mostrarMenuPrincipal();
            switch (opcao) {
                case 1: gerenciarTimes(); break;
                case 2: gerenciarJogadores(); break;
                case 0: rodando = false; break;
                default: view.mostrarMensagem("Opção inválida.");
            }
        }
        view.mostrarMensagem("Saindo...");
        view.fechar();
    }

    private void gerenciarTimes() {
        boolean rodando = true;
        while (rodando) {
            int opcao = view.mostrarMenuTimes();
            switch (opcao) {
                case 1: listarTimes(); break;
                case 2: adicionarTime(); break;
                case 3: atualizarTime(); break;
                case 4: removerTime(); break;
                case 5: listarJogadoresDeUmTime(); break;
                case 0: rodando = false; break;
                default: view.mostrarMensagem("Opção inválida.");
            }
            if (rodando) view.aguardarEnter();
        }
    }

    private void gerenciarJogadores() {
        boolean rodando = true;
        while (rodando) {
            int opcao = view.mostrarMenuJogadores();
            switch (opcao) {
                case 1: listarTodosJogadores(); break;
                case 2: adicionarJogador(); break;
                case 3: atualizarJogador(); break;
                case 4: removerJogador(); break;
                case 5: contratarJogador(); break;
                case 6: demitirJogador(); break;
                case 0: rodando = false; break;
                default: view.mostrarMensagem("Opção inválida.");
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
        if(id == null) { view.mostrarMensagem("ID inválido.");
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
        if(id == null) { view.mostrarMensagem("ID inválido.");
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
        if(id == null) { view.mostrarMensagem("ID inválido.");
            return;
        }

        if (!timeService.buscarPorId(id).isPresent()) {
            view.mostrarMensagem("Time não encontrado.");
            return;
        }

        view.mostrarListaJogadores(jogadorService.listarJogadoresPorTime(id));
    }

    private void listarTodosJogadores() {
        view.mostrarListaJogadores(jogadorService.listarTodos());
    }

    private void adicionarJogador() {
        Jogador jogador = view.lerNovoJogador();
        if(jogador == null) return;
        try {
            jogadorService.salvar(jogador);
            view.mostrarMensagem("Jogador '" + jogador.getNome() + "' salvo com ID " + jogador.getId());
        } catch (Exception e) {
            view.mostrarMensagem("Erro: " + e.getMessage());
        }
    }

    private void atualizarJogador() {
        view.mostrarMensagem("Função de atualizar jogador ainda não implementada.");
    }

    private void removerJogador() {
        Long id = view.lerId("jogador para remover");
        if(id == null) { view.mostrarMensagem("ID inválido.");
            return;
        }

        try {
            jogadorService.remover(id);
            view.mostrarMensagem("Jogador removido com sucesso.");
        } catch (Exception e) {
            view.mostrarMensagem("Erro: " + e.getMessage());
        }
    }

    private void contratarJogador() {
        Long jogadorId = view.lerId("jogador");
        if (jogadorId == null) { view.mostrarMensagem("ID de jogador inválido.");
            return;
        }

        Long timeId = view.lerId("time");
        if (timeId == null) { view.mostrarMensagem("ID de time inválido.");
            return;
        }

        try {
            Jogador j = jogadorService.contratarJogador(jogadorId, timeId);
            view.mostrarMensagem("Jogador '" + j.getNome() + "' contratado pelo time ID " + timeId);
        } catch (Exception e) {
            view.mostrarMensagem("Erro na contratação: " + e.getMessage());
        }
    }

    private void demitirJogador() {
        Long jogadorId = view.lerId("jogador");
        if (jogadorId == null) { view.mostrarMensagem("ID de jogador inválido.");
            return;
        }

        try {
            Jogador j = jogadorService.demitirJogador(jogadorId);
            view.mostrarMensagem("Jogador '" + j.getNome() + "' agora está 'Sem Clube'.");
        } catch (Exception e) {
            view.mostrarMensagem("Erro: " + e.getMessage());
        }
    }
}