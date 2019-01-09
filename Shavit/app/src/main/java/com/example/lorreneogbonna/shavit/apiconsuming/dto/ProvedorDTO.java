package com.example.lorreneogbonna.shavit.apiconsuming.dto;

import com.example.lorreneogbonna.shavit.Model.Provedor;

public class ProvedorDTO {

    private Long id;
    private String nome;
    private String telefone;

    public ProvedorDTO () {

    }

    public ProvedorDTO(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Provedor convertToEntity () {

        Provedor provedor = new Provedor();
        provedor.setNome(this.nome);
        provedor.setTelefone(this.telefone);
        provedor.setId(this.id);

        return provedor;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
