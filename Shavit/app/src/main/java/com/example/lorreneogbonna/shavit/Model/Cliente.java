package com.example.lorreneogbonna.shavit.Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Cadastro {

    List<Agendamento> agendamentos;
    List<Pedido> pedidos;
    int idade;

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;

    }

    public Cliente () {

    }

    public Cliente(String nome, String email, int idade, String morada, String telefone, String nif, String password) {
        super(nome, email, morada, telefone, nif, password);
        this.idade = idade;
        this.agendamentos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
}
