package com.paulsanunga.caso1final.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Garantia {

    public static Retrofit postGarantia(String url){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

}
