package com.example.lorreneogbonna.shavit.Model;

public class Cliente extends Cadastro {
    int idade;
    public Cliente(String nome, String email, int idade, String morada, String telefone, String nif) {
        super(nome, email, idade, morada, telefone, nif);
        this.idade = idade;
    }
}
