package com.example.lorreneogbonna.shavit.apiconsuming.dto;

public class PedidoSimplesDTO {

    private Long idPedido;

    public PedidoSimplesDTO () {

    }

    public PedidoSimplesDTO(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
