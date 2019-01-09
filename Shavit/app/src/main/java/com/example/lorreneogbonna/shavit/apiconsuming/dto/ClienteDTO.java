package com.example.lorreneogbonna.shavit.apiconsuming.dto;

import com.example.lorreneogbonna.shavit.Model.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String morada;
    private String nif;
    private String telefone;

    public ClienteDTO () {

    }

    public ClienteDTO(Long id, String nome, String email, String morada, String nif, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.nif = nif;
        this.telefone = telefone;
    }

    public Cliente convertToEntity () {
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setMorada(this.morada);
        cliente.setNif(this.nif);
        cliente.setTelefone(this.telefone);

        return cliente;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
