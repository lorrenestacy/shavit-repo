package com.example.lorreneogbonna.shavit.Model;

public class Pedido {
    public Pedido(Cliente cliente, Clinica clinica, String horario, String data, Servico servico) {
        this.cliente = cliente;
        this.clinica = clinica;
        this.horario = horario;
        this.data = data;
        this.servico = servico;
    }

    Cliente cliente;
    Clinica clinica;
    String horario;
    String data;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    Servico servico;


}
