package com.example.lorreneogbonna.shavit.apiconsuming.dto;

import com.example.lorreneogbonna.shavit.Model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoDTO {

    private Long id;
    private String nomeServico;
    private String descricaoServico;
    private Long duracao;
    private String observacao;
    private Float preco;
    private List<ProvedorDTO> provedores = new ArrayList<>();

    public ServicoDTO () {

    }

    public ServicoDTO(Long id, String nomeServico,
                      String descricaoServico,
                      Long duracao, String observacao,
                      Float preco, List<ProvedorDTO> provedores) {

        this.id = id;
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
        this.duracao = duracao;
        this.observacao = observacao;
        this.preco = preco;
        this.provedores = provedores;
    }

    public Servico convertToEntity () {

        Servico servico = new Servico();
        servico.setNome(this.nomeServico);
        servico.setDescricao(this.descricaoServico);
        servico.setObservacao(this.observacao);
        servico.setPreco(this.preco);
        servico.setDuracao(this.duracao);

        return servico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public List<ProvedorDTO> getProvedores() {
        return provedores;
    }

    public void setProvedores(List<ProvedorDTO> provedores) {
        this.provedores = provedores;
    }
}
