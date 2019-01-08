package com.example.lorreneogbonna.shavit.Model;

import java.util.ArrayList;
import java.util.List;

public class Clinica extends Cadastro {

    private List<Pedido> pedidos;
    private List<Agendamento> agendamentos;
    private List<Servico> servicos;
    private List<Provedor> provedores;

    public Clinica(String nome, String email, String morada, String telefone, String nif, String password) {
        super(nome, email, morada, telefone, nif, password);
        this.pedidos = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.provedores = new ArrayList<>();
        this.agendamentos = new ArrayList<>();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Provedor> getProvedores() {
        return provedores;
    }

    public void setProvedores(List<Provedor> provedores) {
        this.provedores = provedores;
    }

}
