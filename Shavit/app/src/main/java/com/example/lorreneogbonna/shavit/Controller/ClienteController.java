package com.example.lorreneogbonna.shavit.Controller;

import com.example.lorreneogbonna.shavit.Model.Agendamento;
import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Pedido;

import java.util.List;

public class ClienteController extends Cliente {

    List<Agendamento> agendamentos;
    List<Pedido> pedidos;

    public ClienteController(String nome, String email, int idade, String morada, String telefone, String nif) {
        super(nome, email, idade, morada, telefone, nif);
    }

    private void criarPedido(int clinica){
        //find Clinica

//        Pedido pedido = new Pedido(this, )
    }

}
