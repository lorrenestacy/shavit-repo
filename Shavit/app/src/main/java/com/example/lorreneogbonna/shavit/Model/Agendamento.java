package com.example.lorreneogbonna.shavit.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "agendamento")
public class Agendamento {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "pedido")
    private Pedido pedido;

    @ColumnInfo(name = "provedor")
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
