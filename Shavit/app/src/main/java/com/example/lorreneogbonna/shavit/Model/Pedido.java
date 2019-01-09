package com.example.lorreneogbonna.shavit.Model;

import java.io.Serializable;

public class Pedido implements Serializable {

    private Long id;
    private Cliente cliente;
    private Clinica clinica;
    private String horario;
    private String data;
    private Servico servico;

    public Pedido () {

    }

    public Pedido(Cliente cliente, Clinica clinica, String horario, String data, Servico servico) {
        this.cliente = cliente;
        this.clinica = clinica;
        this.horario = horario;
        this.data = data;
        this.servico = servico;
    }

    public Pedido(Cliente cliente, String horario, String data, Servico servico) {
        this.cliente = cliente;
        this.horario = horario;
        this.data = data;
        this.servico = servico;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
