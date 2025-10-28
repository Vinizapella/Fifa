package com.SistemaFifa.model;

public class Time {
    private Long id;
    private String nome;
    private String cidade;

    public Time(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Time: " + nome + " | Cidade: " + cidade;
    }
}