package com.SistemaFifa.controller;


import com.SistemaFifa.model.Jogador;
import com.SistemaFifa.service.JogadorService;
import com.SistemaFifa.view.AppView;

public class JogadorController {

    private final AppView view;
    private final JogadorService jogadorService;

    public JogadorController(AppView view, JogadorService jogadorService) {
        this.view = view;
        this.jogadorService = jogadorService;
    }

    public void iniciar() {
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
                case 0: rodando = false;
                    break;
                default:
                    view.mostrarMensagem("Opção inválida.");
            }
            if (rodando) view.aguardarEnter();
        }
    }

    private void listarTodosJogadores() {
        view.mostrarListaJogadores(jogadorService.listarTodos());
    }

    private void adicionarJogador() {
        Jogador jogador = view.lerNovoJogador();
        if(jogador == null)
            return;
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
        if(id == null) {
            view.mostrarMensagem("ID inválido.");
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
        if (jogadorId == null) {
            view.mostrarMensagem("ID de jogador inválido.");
            return;
        }

        Long timeId = view.lerId("time");
        if (timeId == null) {
            view.mostrarMensagem("ID de time inválido.");
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
        if (jogadorId == null) {
            view.mostrarMensagem("ID de jogador inválido.");
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