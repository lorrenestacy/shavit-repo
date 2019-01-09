package com.example.lorreneogbonna.shavit.Model;

import java.util.ArrayList;
import java.util.List;

public class Provedor {

    private String nome;
    private String telefone;
    private List<Servico> servicos;

    public Provedor () { }

    public Provedor (String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.servicos = new ArrayList<>();
    }

    public Provedor(String nome, String telefone, List<Servico> servicos) {
        this.nome = nome;
        this.telefone = telefone;
        this.servicos = servicos;
    }

    //region getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    //endregion

    @Override
    public String toString() {
        return this.getNome();
    }
}
