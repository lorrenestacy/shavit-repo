package com.example.lorreneogbonna.shavit.Controller;

import com.example.lorreneogbonna.shavit.Model.Cadastro;
import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Clinica;

import java.util.List;

public class AppController {
    List<Cliente> clientes; //passar para o banco depois
    List<Clinica> clinicas;
    ClienteController clienteController;
    ClinicaController clinicaController;
    Login loginController;

private boolean cadastrarUser(int tipoUser){
    //tipoUser 1 - clinica 2 cliente

    if(tipoUser==1){

    }
    else if(tipoUser ==2){

    }
    return false;
}
}
