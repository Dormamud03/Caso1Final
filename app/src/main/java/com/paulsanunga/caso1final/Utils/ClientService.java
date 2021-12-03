package com.paulsanunga.caso1final.Utils;

import com.paulsanunga.caso1final.Model.Client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClientService {

    @GET("/find/")
    Call<Client> getClient();

    @POST("save")
    Call<Client> addClient(@Body Client client);

    @GET("login")
    Call<Client> loginClient(@Query("cedulaClient") String cedulaClient, @Query("passwordClient")String passwordClient);
}
