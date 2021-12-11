package com.paulsanunga.caso1final.Utils;

import com.paulsanunga.caso1final.Model.CatalogoVehiculos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatalogoVehiculosService {

    @GET("all")
    Call<List<CatalogoVehiculos>> getCatalogo();
}
