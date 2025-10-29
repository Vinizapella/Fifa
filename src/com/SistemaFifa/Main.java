package com.SistemaFifa;

import com.SistemaFifa.controller.AppController;
import com.SistemaFifa.controller.JogadorController;
import com.SistemaFifa.controller.TimeController;
import com.SistemaFifa.repository.JogadorRepository;
import com.SistemaFifa.repository.TimeRepository;
import com.SistemaFifa.repository.impl.JogadorMemoriaRepository;
import com.SistemaFifa.repository.impl.TimeMemoriaRepository;
import com.SistemaFifa.service.JogadorService;
import com.SistemaFifa.service.TimeService;
import com.SistemaFifa.service.impl.JogadorServiceImpl;
import com.SistemaFifa.service.impl.TimeServiceImpl;
import com.SistemaFifa.view.AppView;

public class Main {
    public static void main(String[] args) {

        AppView view = new AppView();

        TimeRepository timeRepository = new TimeMemoriaRepository();
        JogadorRepository jogadorRepository = new JogadorMemoriaRepository();

        TimeService timeService = new TimeServiceImpl(timeRepository, jogadorRepository);
        JogadorService jogadorService = new JogadorServiceImpl(jogadorRepository, timeRepository);

        TimeController timeController = new TimeController(view, timeService, jogadorService);
        JogadorController jogadorController = new JogadorController(view, jogadorService);

        AppController appController = new AppController(view, timeController, jogadorController);

        appController.iniciar();
    }
}