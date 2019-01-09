package com.example.lorreneogbonna.shavit.Model;

import java.util.ArrayList;
import java.util.List;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "clientes")
public class Cliente extends Cadastro {
    @Ignore
    @Embedded
    List<Agendamento> agendamentos;
    @Ignore
    @Embedded
    List<Pedido> pedidos;
    @Ignore
    @ColumnInfo(name = "idade")
    int idade;

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;

    }

    public Cliente(String nome, String email, int idade, String morada, String telefone, String nif, String password) {
        super(nome, email, morada, telefone, nif, password);
        this.idade = idade;
        this.agendamentos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
}
