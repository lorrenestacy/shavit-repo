package com.example.lorreneogbonna.shavit.Model;

import java.util.List;

public class Servico {

    private String tipo;
    private String nome;
    private String descricao;
    private double duracao;
    private List<Provedor> provedores;
    private String observacao;
    private double preco;
    private String areaCorpo;
    private Clinica clinica;

    public Clinica getClinica() {
        return clinica;
    }

    public String getAreaCorpo() {
        return areaCorpo;
    }

    //For the purposes of demonstrating the behaviour of the list, the only things we care about
    public Servico (String nome, String descricao, double preco, double duracao, Clinica clinica, String areaCorpo) {
        this.nome = nome;
        this.descricao = descricao;

        this.preco = preco;
        this.areaCorpo = areaCorpo;
        this.duracao = duracao;
        this.clinica = clinica;
    }

    //region getters and setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public List<Provedor> getProvedores() {
        return provedores;
    }

    public void setProvedores(List<Provedor> provedores) {
        this.provedores = provedores;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    //endregion
}
