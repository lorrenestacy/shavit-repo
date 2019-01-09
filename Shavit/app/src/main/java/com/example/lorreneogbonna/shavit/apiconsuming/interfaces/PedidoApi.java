package com.example.lorreneogbonna.shavit.apiconsuming.interfaces;


import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoAgendamentoDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoDTO;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.PedidoSimplesDTO;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PedidoApi {

    @GET("pedido/solicitados")
    Call<List<PedidoDTO>> getListPedidosSolicitados();

    @GET("pedido/agendados")
    Call<List<PedidoDTO>> getListPedidosAgendados();

    @POST("pedido/agendar")
    Call<ResponseBody> agendarPedido (@Body PedidoAgendamentoDTO pedidoAgendamentoDTO);

    @POST("pedido/cancelar")
    Call<ResponseBody> cancelarPedido (@Body PedidoSimplesDTO pedidoSimplesDTO);

    @POST("pedido/realizar")
    Call<ResponseBody> realizarPedido (@Body PedidoSimplesDTO pedidoSimplesDTO);

    @POST("pedido/recusar")
    Call<ResponseBody> recusarPedido (@Body PedidoSimplesDTO pedidoSimplesDTO);

}
