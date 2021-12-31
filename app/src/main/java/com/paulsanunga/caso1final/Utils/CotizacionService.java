package com.paulsanunga.caso1final.Utils;

import com.paulsanunga.caso1final.Model.Client;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CotizacionService {

    @GET("enviar-correo-cotizacion")
    Call<String> getCotizacion(@Query("chasis") Long chasis, @Query("nombreClient")String nombreClient,
                                        @Query("emailClient")String emailClient);
}
