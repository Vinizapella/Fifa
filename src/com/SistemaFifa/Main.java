package com.SistemaFifa;


import com.SistemaFifa.controller.AppController;
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

        TimeRepository timeRepository = new TimeMemoriaRepository();
        JogadorRepository jogadorRepository = new JogadorMemoriaRepository();

        TimeService timeService = new TimeServiceImpl(timeRepository, jogadorRepository);
        JogadorService jogadorService = new JogadorServiceImpl(jogadorRepository, timeRepository);

        AppView view = new AppView();

        AppController controller = new AppController(view, timeService, jogadorService);

        controller.iniciar();
    }
}