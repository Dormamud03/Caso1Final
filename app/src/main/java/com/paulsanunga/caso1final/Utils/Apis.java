package com.paulsanunga.caso1final.Utils;


public class Apis {

    public static final String URL_001 = "url/cliente/api/v1/";
    public static final String URL_002 = "url/vehiculo_catalogo/api/v1/";
    public static final String URL_003 = "url/solicitud/garantia/api/v1/";



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
