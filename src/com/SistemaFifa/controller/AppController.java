package com.SistemaFifa.controller;

import com.SistemaFifa.controller.JogadorController;
import com.SistemaFifa.controller.TimeController;
import com.SistemaFifa.view.AppView;

public class AppController {

    private final AppView view;
    private final TimeController timeController;
    private final JogadorController jogadorController;

    public AppController(AppView view, TimeController timeController, JogadorController jogadorController) {
        this.view = view;
        this.timeController = timeController;
        this.jogadorController = jogadorController;
    }

    public void iniciar() {
        boolean rodando = true;
        while (rodando) {
            int opcao = view.mostrarMenuPrincipal();
            switch (opcao) {
                case 1:
                    timeController.iniciar();
                    break;
                case 2:
                    jogadorController.iniciar();
                    break;
                case 0:
                    rodando = false;
                    break;
                default:
                    view.mostrarMensagem("Opção inválida.");
            }
        }
        view.mostrarMensagem("Saindo...");
        view.fechar();
    }
}