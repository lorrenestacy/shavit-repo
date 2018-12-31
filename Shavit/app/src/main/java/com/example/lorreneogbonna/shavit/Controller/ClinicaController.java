package com.example.lorreneogbonna.shavit.Controller;

import com.example.lorreneogbonna.shavit.Model.Clinica;
import com.example.lorreneogbonna.shavit.Model.Pedido;
import com.example.lorreneogbonna.shavit.Model.Servico;

import java.util.List;

public class ClinicaController {

    private void aceitarPedido(Clinica clinica, Pedido pedido){
        //cria um agendamento e guarda na lista
    }
    private void rejeitarPedido(Clinica clinica, Pedido pedido){
        //cria um agendamento e guarda na lista
    }
    private void adicionarServico(Clinica clinica, Servico servico){
        clinica.getServicos().add(servico);
    }

}
