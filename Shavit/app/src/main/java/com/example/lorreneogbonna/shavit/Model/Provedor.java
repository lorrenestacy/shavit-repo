package com.example.lorreneogbonna.shavit.Model;

import java.util.List;

public class Provedor {
    String nome;
    String telefone;
    List<Servico> servicos;

    public Provedor(String nome, String telefone, List<Servico> servicos) {
        this.nome = nome;
        this.telefone = telefone;
        this.servicos = servicos;
    }
}
