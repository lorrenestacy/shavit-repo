package com.example.lorreneogbonna.shavit.apiconsuming.interfaces;


import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PedidoApi {

    @GET("pedido/solicitados")
    Call<List<PedidoDTO>> getListPedidosSolicitados();

    @GET("pedido/agendados")
    Call<List<PedidoDTO>> getListPedidosAgendados();

}
