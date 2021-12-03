package com.paulsanunga.caso1final.Utils;

import com.paulsanunga.caso1final.Model.Client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientService {

    @GET("/find/")
    Call<Client> getClient();

    @POST("save")
    Call<Client> addClient(@Body Client client);
}
