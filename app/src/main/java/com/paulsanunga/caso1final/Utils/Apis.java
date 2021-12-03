package com.paulsanunga.caso1final.Utils;

public class Apis {

    public static final String URL_001 = "http://192.168.1.100:8080/cliente/api/v1/";

    public static ClientService getClientService(){
        return User.getClient(URL_001).create(ClientService.class);
    }
}
