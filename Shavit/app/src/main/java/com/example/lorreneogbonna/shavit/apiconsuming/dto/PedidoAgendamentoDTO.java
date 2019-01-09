package com.example.lorreneogbonna.shavit.apiconsuming.dto;

public class PedidoAgendamentoDTO {

    private Long idPedido;
    private Long idProvedor;

    PedidoAgendamentoDTO () {

    }

    public PedidoAgendamentoDTO(Long idPedido, Long idProvedor) {
        this.idPedido = idPedido;
        this.idProvedor = idProvedor;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Long idProvedor) {
        this.idProvedor = idProvedor;
    }
}
