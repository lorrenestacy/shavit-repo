package com.example.lorreneogbonna.shavit.apiconsuming.interfaces;

import com.example.lorreneogbonna.shavit.apiconsuming.dto.ProvedorDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProvedorApi {

    @GET("provedor")
    Call<List<ProvedorDTO>> listProvedores();

}
