package com.example.lorreneogbonna.shavit.apiconsuming.dto;

import com.example.lorreneogbonna.shavit.Model.Agendamento;
import com.example.lorreneogbonna.shavit.Model.Cliente;
import com.example.lorreneogbonna.shavit.Model.Pedido;
import com.example.lorreneogbonna.shavit.Model.Provedor;
import com.example.lorreneogbonna.shavit.Model.Servico;

public class PedidoDTO {

    private Long id;
    private ClienteDTO cliente;
    private ServicoDTO servico;
    private String estado;
    private ProvedorDTO provedor;
    private String data;
    private String hora;

    public PedidoDTO () {

    }

    public PedidoDTO(Long id, ClienteDTO cliente, ServicoDTO servico, String estado, ProvedorDTO provedor, String data, String hora) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.estado = estado;
        this.provedor = provedor;
        this.data = data;
        this.hora = hora;
    }

    public Pedido convertToPedido () {

        Pedido pedido = new Pedido();
        pedido.setCliente(this.cliente.convertToEntity());
        pedido.setServico(this.servico.convertToEntity());
        pedido.setData(this.data);
        pedido.setHorario(this.hora);
        pedido.setId(this.id);

        return pedido;
    }

    public Agendamento convertToAgendamento () {

        Agendamento agendamento = new Agendamento();
        agendamento.setPedido(this.convertToPedido());
        agendamento.setProvedor(this.provedor.convertToEntity());

        return agendamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ServicoDTO getServico() {
        return servico;
    }

    public void setServico(ServicoDTO servico) {
        this.servico = servico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ProvedorDTO getProvedor() {
        return provedor;
    }

    public void setProvedor(ProvedorDTO provedor) {
        this.provedor = provedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
