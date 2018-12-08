package com.example.lorreneogbonna.shavit.Model;

public class Agendamento extends Pedido{
    Pedido pedido;
    Provedor provedor;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    public Agendamento(Cliente cliente, Clinica clinica, String horario, String data, Servico servico) {
        super(cliente, clinica, horario, data, servico);
    }
}
