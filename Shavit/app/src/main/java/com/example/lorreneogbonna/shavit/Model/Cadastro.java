package com.example.lorreneogbonna.shavit.Model;

public class Cadastro {
    String nome;
    String email; //colocar regez de validaçao
    String morada;
    String telefone;
    String nif;
    String password;

    public Cadastro(String nome, String email, String morada, String telefone, String nif, String password) {
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.telefone = telefone;
        this.nif = nif;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
}
