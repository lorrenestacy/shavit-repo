package com.example.lorreneogbonna.shavit.Model;

import java.util.List;

public class Servico {

    private String tipo;
    private String nome;
    private String descricao;
    private float duracao;
    private List<Provedor> provedores;
    private String observacao;
    private float preco;

    //For the purposes of demonstrating the behaviour of the list, the only things we care about
    public Servico (String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    public float getDuracao() {
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    //endregion
}
