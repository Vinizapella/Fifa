package com.SistemaFifa.view;

import com.SistemaFifa.model.Jogador;
import com.SistemaFifa.model.Time;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class AppView {
    private final Scanner scanner;

    public AppView() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n--- Campeonato Manager (Terminal) ---");
        System.out.println("1. Gerenciar Times");
        System.out.println("2. Gerenciar Jogadores");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return lerOpcao();
    }

    public int mostrarMenuTimes() {
        System.out.println("\n--- Gerenciar Times ---");
        System.out.println("1. Listar Times");
        System.out.println("2. Adicionar Novo Time");
        System.out.println("3. Atualizar Time");
        System.out.println("4. Remover Time");
        System.out.println("5. Ver Jogadores do Time");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        return lerOpcao();
    }

    public int mostrarMenuJogadores() {
        System.out.println("\n--- Gerenciar Jogadores ---");
        System.out.println("1. Listar Todos os Jogadores");
        System.out.println("2. Adicionar Novo Jogador");
        System.out.println("3. Atualizar Jogador");
        System.out.println("4. Remover Jogador");
        System.out.println("5. Contratar Jogador para Time");
        System.out.println("6. Demitir Jogador (Definir Sem Clube)");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
        return lerOpcao();
    }

    public int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Long lerId(String tipo) {
        System.out.print("Digite o ID do " + tipo + ": ");
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Time lerNovoTime() {
        System.out.print("Nome do Time: ");
        String nome = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        return new Time(nome, cidade);
    }

    public Jogador lerNovoJogador() {
        try {
            System.out.print("Nome do Jogador: ");
            String nome = scanner.nextLine();
            System.out.print("Posição: ");
            String posicao = scanner.nextLine();
            System.out.print("Data Nascimento (YYYY-MM-DD): ");
            LocalDate data = LocalDate.parse(scanner.nextLine());
            return new Jogador(nome, posicao, data);
        } catch (DateTimeParseException e) {
            mostrarMensagem("Formato de data inválido!");
            return null;
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println("\n[SISTEMA] " + mensagem);
    }

    public void mostrarListaTimes(List<Time> times) {
        if (times.isEmpty()) {
            mostrarMensagem("Nenhum time cadastrado.");
        } else {
            System.out.println("\n--- Lista de Times ---");
            times.forEach(System.out::println);
        }
    }

    public void mostrarListaJogadores(List<Jogador> jogadores) {
        if (jogadores.isEmpty()) {
            mostrarMensagem("Nenhum jogador encontrado.");
        } else {
            System.out.println("\n--- Lista de Jogadores ---");
            jogadores.forEach(System.out::println);
        }
    }

    public void aguardarEnter() {
        System.out.print("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    public void fechar() {
        scanner.close();
    }
}