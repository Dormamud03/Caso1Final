package com.paulsanunga.caso1final.Utils;


public class Apis {

    public static final String URL_001 = "https://starmotors1.herokuapp.com/cliente/api/v1/";
    public static final String URL_002 = "https://starmotors1.herokuapp.com/vehiculo_catalogo/api/v1/";
    public static final String URL_003 = "https://starmotors1.herokuapp.com/solicitud/garantia/api/v1/";
    public static final String URL_004 = "https://starmotors1.herokuapp.com/cotizaciones/api/v1/";




    public static ClientService getClientService(){
        return User.getClient(URL_001).create(ClientService.class);
    }

    public static CatalogoVehiculosService getCatalogoVehiculosService(){
        return Catalogo.getCatalogo(URL_002).create(CatalogoVehiculosService.class);
    }

    public static MisVehiculosService getMisVehiculosService(){
        return MisVehiculosUtils.getMisVehiculos(URL_003).create(MisVehiculosService.class);
    }

    public static CotizacionService getCotizarService(){
        return Cotizacion.getCotizacion(URL_004).create(CotizacionService.class);
    }

}
