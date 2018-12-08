package com.example.lorreneogbonna.shavit.Model;

public class Promocao {
    Clinica clinica;
    Servico servico;
    String preco;

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDercricao() {
        return dercricao;
    }

    public void setDercricao(String dercricao) {
        this.dercricao = dercricao;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Promocao(Clinica clinica, Servico servico, String preco, String dercricao, String periodo) {
        this.clinica = clinica;
        this.servico = servico;
        this.preco = preco;
        this.dercricao = dercricao;
        this.periodo = periodo;
    }

    String dercricao;
    String periodo;
}
