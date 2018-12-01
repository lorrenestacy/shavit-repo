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
    Servico servico;


}
