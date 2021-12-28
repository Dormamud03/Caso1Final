package com.paulsanunga.caso1final.Utils;


public class Apis {

    public static final String URL_001 = "http://192.168.1.100:8080/cliente/api/v1/";
    public static final String URL_002 = "http://192.168.1.100:8080/vehiculo_catalogo/api/v1/";
    public static final String URL_003 = "http://192.168.1.100:8080/solicitud/garantia/api/v1/";



    public static ClientService getClientService(){
        return User.getClient(URL_001).create(ClientService.class);
    }

    public static CatalogoVehiculosService getCatalogoVehiculosService(){
        return Catalogo.getCatalogo(URL_002).create(CatalogoVehiculosService.class);
    }

    public static MisVehiculosService getMisVehiculosService(){
        return MisVehiculosUtils.getMisVehiculos(URL_003).create(MisVehiculosService.class);
    }

}
