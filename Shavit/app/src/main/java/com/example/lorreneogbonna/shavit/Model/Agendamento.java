package com.example.lorreneogbonna.shavit.Model;

public class Agendamento {

    private Pedido pedido;
    private Provedor provedor;

    public Agendamento(Cliente cliente, Clinica clinica, String horario, String data, Servico servico) {

        Pedido pedido = new Pedido (cliente, clinica, horario, data, servico);
        this.pedido = pedido;

        this.provedor = null; //TODO for nwo
    }

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


}
