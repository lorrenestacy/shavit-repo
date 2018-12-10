package com.example.lorreneogbonna.shavit.Model;

public class Cliente extends Cadastro {
    int idade;

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;

    }

    public Cliente(String nome, String email, int idade, String morada, String telefone, String nif, String password) {
        super(nome, email, morada, telefone, nif, password);
        this.idade = idade;
    }
}
