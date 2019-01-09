package com.example.lorreneogbonna.shavit.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pedido")
public class Pedido {
    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    @ColumnInfo(name = "cliente")
    private Cliente cliente;
    @ColumnInfo(name = "clinica")
    private Clinica clinica;
    @ColumnInfo(name = "horario")
    private String horario;
    @ColumnInfo(name = "data")
    private String data;
    @ColumnInfo(name = "servico")
    private Servico servico;

    public Pedido(Cliente cliente, Clinica clinica, String horario, String data, Servico servico) {
        this.cliente = cliente;
        this.clinica = clinica;
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


}
