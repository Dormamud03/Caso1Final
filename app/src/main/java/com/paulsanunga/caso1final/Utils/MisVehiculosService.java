package com.paulsanunga.caso1final.Utils;

import com.paulsanunga.caso1final.Model.Client;
import com.paulsanunga.caso1final.Model.VehiculoCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MisVehiculosService {

    @GET("cars/{id}")
    Call<List<String>> getVehiculosClient(@Path("id") String id);

}
