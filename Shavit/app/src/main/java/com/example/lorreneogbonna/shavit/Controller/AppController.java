package com.example.lorreneogbonna.shavit.Controller;

import com.example.lorreneogbonna.shavit.Model.Cadastro;
import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Clinica;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    List<Cliente> clientes; //passar para o banco depois
    List<Clinica> clinicas;
    ClienteController clienteController;
    ClinicaController clinicaController;
    Login loginController;

    public AppController() {
        this.clientes = new ArrayList<Cliente>();
        this.clinicas = new ArrayList<Clinica>();
        this.clienteController = new ClienteController();
        this.clinicaController = new ClinicaController();
        this.loginController = new Login();
    }
    public int cadastrarCliente(String nome,String email,String morada,String telefone,String nif, int idade, String password){
        Cliente cliente = new Cliente(nome,  email,  idade,  morada,  telefone,  nif, password);
        clientes.add(cliente);
        return clientes.size() -1; //fazer retornar -1 pra uma falha no cadastro
    }

    public int cadastrarCliente(final MyDatabase db, String nome,String email,String morada,String telefone,String nif, int idade, String password){
        Cliente cliente = new Cliente(nome,  email,  idade,  morada,  telefone,  nif, password);
        db.myDao().addCliente(cliente);

//        clientes.add(cliente);
        return 1; //fazer retornar -1 pra uma falha no cadastro
    }

    public int cadastrarClinica(String nome,String email,String morada,String telefone,String nif, String password){
        Clinica clinica = new Clinica(nome,  email,  morada,  telefone,  nif, password);
        clinicas.add(clinica);
        return clinicas.size() -1; //fazer retornar -1 pra uma falha no cadastro
    }
    public Cadastro login(String user, String pass, int typeUser){
        return loginController.autenticar(clientes, clinicas, user, pass, typeUser);
    }
}
