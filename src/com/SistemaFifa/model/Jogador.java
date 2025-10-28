package com.SistemaFifa.model;

import java.time.LocalDate;
import java.time.Period;

public class Jogador {
    private Long id;
    private String nome;
    private String posicao;
    private LocalDate dataNascimento;
    private Long timeId;

    public Jogador(String nome, String posicao, LocalDate dataNascimento) {
        this.nome = nome;
        this.posicao = posicao;
        this.dataNascimento = dataNascimento;
        this.timeId = null;
    }

    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    @Override
    public String toString() {
        String clube = (timeId == null) ? "Sem Clube" : "Time ID: " + timeId;
        return "ID: " + id + " | Nome: " + nome + " | Posição: " + posicao + " | Clube: " + clube;
    }
}