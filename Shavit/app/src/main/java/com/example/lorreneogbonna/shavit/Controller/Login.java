package com.example.lorreneogbonna.shavit.Controller;

import com.example.lorreneogbonna.shavit.Model.Cadastro;
import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Clinica;

import java.util.List;

public class Login {

    public Cadastro autenticar(List<Cliente> clientes, List<Clinica> clinicas, String user, String pass, int typeuser){
        if(typeuser==1){//clinica
            int index = 0;
            for(Clinica clinica : clinicas) {
                index++;
                if(clinica.getNome().equals(user) && clinica.getPassword().equals(pass)) {
                    return clinica;
                }
            }
            return null;
        }
        else {//cliente
            int index = 0;
            for(Cliente cliente : clientes) {
                index++;
                if(cliente.getNome().equals(user) && cliente.getPassword().equals(pass)) {
                    return cliente;
                }
            }
            return null;
        }
    }
}
