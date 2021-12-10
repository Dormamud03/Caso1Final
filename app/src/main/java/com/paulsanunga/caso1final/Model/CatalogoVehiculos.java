package com.paulsanunga.caso1final.Model;

public class CatalogoVehiculos {

    private Long idVehiculoCatalogo;
    private DisenioVehiculo disenioVehiculo;
    private int yearVehiculo;
    private CaracteristicaVehiculo caracteristicaVehiculo;
    private String links_imagen;

    public CatalogoVehiculos(Long idVehiculoCatalogo, DisenioVehiculo disenioVehiculo, int yearVehiculo, CaracteristicaVehiculo caracteristicaVehiculo, String links_imagen) {
        this.idVehiculoCatalogo = idVehiculoCatalogo;
        this.disenioVehiculo = disenioVehiculo;
        this.yearVehiculo = yearVehiculo;
        this.caracteristicaVehiculo = caracteristicaVehiculo;
        this.links_imagen = links_imagen;
    }

    public CatalogoVehiculos() {
    }

    public Long getIdVehiculoCatalogo() {
        return idVehiculoCatalogo;
    }

    public void setIdVehiculoCatalogo(Long idVehiculoCatalogo) {
        this.idVehiculoCatalogo = idVehiculoCatalogo;
    }

    public DisenioVehiculo getDisenioVehiculo() {
        return disenioVehiculo;
    }

    public void setDisenioVehiculo(DisenioVehiculo disenioVehiculo) {
        this.disenioVehiculo = disenioVehiculo;
    }

    public int getYearVehiculo() {
        return yearVehiculo;
    }

    public void setYearVehiculo(int yearVehiculo) {
        this.yearVehiculo = yearVehiculo;
    }

    public CaracteristicaVehiculo getCaracteristicaVehiculo() {
        return caracteristicaVehiculo;
    }

    public void setCaracteristicaVehiculo(CaracteristicaVehiculo caracteristicaVehiculo) {
        this.caracteristicaVehiculo = caracteristicaVehiculo;
    }

    public String getLinks_imagen() {
        return links_imagen;
    }

    public void setLinks_imagen(String links_imagen) {
        this.links_imagen = links_imagen;
    }
}
