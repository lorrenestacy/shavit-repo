package com.example.lorreneogbonna.shavit.apiconsuming.interfaces;

import com.example.lorreneogbonna.shavit.Model.Servico;
import com.example.lorreneogbonna.shavit.apiconsuming.dto.ServicoDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicoApi {

    @GET("servico")
    Call<List<ServicoDTO>> getListServicos();

}
