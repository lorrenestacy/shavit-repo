package com.example.lorreneogbonna.shavit.Model;

import java.util.List;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "servico")
public class Servico {

    @PrimaryKey
    private int idServico;

    public int getId() {
        return idServico;
    }

    @NonNull
    @ColumnInfo(name = "tipo")
    private String tipo;

    @NonNull
    @ColumnInfo(name = "nome")
    private String nome;

    @NonNull
    @ColumnInfo(name = "descricao")
    private String descricao;

    @NonNull
    @ColumnInfo(name = "duracao")
    private double duracao;

    @NonNull
    @ColumnInfo(name = "observacao")
    private String observacao;

    @NonNull
    @ColumnInfo(name = "preco")
    private double preco;

    @NonNull
    @ColumnInfo(name = "areacorpo")
    private String areaCorpo;

    @NonNull
    @ColumnInfo(name = "clinica")
    private Clinica clinica;
    @Embedded
    private List<Provedor> provedores;

    public Clinica getClinica() {
        return clinica;
    }

    public String getAreaCorpo() {
        return areaCorpo;
    }

    //For the purposes of demonstrating the behaviour of the list, the only things we care about
    public Servico (String nome, String descricao, double preco, double duracao, Clinica clinica, String areaCorpo) {
        this.nome = nome;
        this.descricao = descricao;

        this.preco = preco;
        this.areaCorpo = areaCorpo;
        this.duracao = duracao;
        this.clinica = clinica;
    }

    //region getters and setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public List<Provedor> getProvedores() {
        return provedores;
    }

    public void setProvedores(List<Provedor> provedores) {
        this.provedores = provedores;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    //endregion
}
