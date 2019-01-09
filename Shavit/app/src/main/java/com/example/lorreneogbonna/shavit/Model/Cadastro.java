package com.example.lorreneogbonna.shavit.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cadastro")
public class Cadastro {
    public void setIdCadastro(int idCadastro) {
        this.idCadastro = idCadastro;
    }

    @PrimaryKey
    private int idCadastro;
    @Ignore
    @ColumnInfo(name = "nome")
    String nome;

    @Ignore
    @ColumnInfo(name = "email")
    String email; //colocar regez de validaçao

    @Ignore
    @ColumnInfo(name = "morada")
    String morada;

    @Ignore
    @ColumnInfo(name = "telefone")
    String telefone;

    @Ignore
    @ColumnInfo(name = "nif")
    String nif;

    @Ignore
    @ColumnInfo(name = "password")
    String password;

    public Cadastro(String nome, String email, String morada, String telefone, String nif, String password) {
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.telefone = telefone;
        this.nif = nif;
        this.password = password;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public int getIdCadastro() {
        return idCadastro;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
}
