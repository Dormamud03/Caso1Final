package com.paulsanunga.caso1final.Model;

public class CatalogoVehiculos {

    private long id_vehiculo_catalogo;
    private DisenioVehiculo diseno;
    private int year_vehiculo;
    private CaracteristicaVehiculo caracteristica;
    private String links_imagen;

    public CatalogoVehiculos(long id_vehiculo_catalogo, DisenioVehiculo diseno, int year_vehiculo, CaracteristicaVehiculo caracteristica, String links_imagen) {
        this.id_vehiculo_catalogo = id_vehiculo_catalogo;
        this.diseno = diseno;
        this.year_vehiculo = year_vehiculo;
        this.caracteristica = caracteristica;
        this.links_imagen = links_imagen;
    }

    public CatalogoVehiculos() {
    }

    public long getId_vehiculo_catalogo() {
        return id_vehiculo_catalogo;
    }

    public void setId_vehiculo_catalogo(long id_vehiculo_catalogo) {
        this.id_vehiculo_catalogo = id_vehiculo_catalogo;
    }

    public DisenioVehiculo getDiseno() {
        return diseno;
    }

    public void setDiseno(DisenioVehiculo diseno) {
        this.diseno = diseno;
    }

    public int getYear_vehiculo() {
        return year_vehiculo;
    }

    public void setYear_vehiculo(int year_vehiculo) {
        this.year_vehiculo = year_vehiculo;
    }

    public CaracteristicaVehiculo getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(CaracteristicaVehiculo caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getLinks_imagen() {
        return links_imagen;
    }

    public void setLinks_imagen(String links_imagen) {
        this.links_imagen = links_imagen;
    }

    @Override
    public String toString() {
        return "CatalogoVehiculos{" +
                "id_vehiculo_catalogo=" + id_vehiculo_catalogo +
                ", diseno=" + diseno +
                ", year_vehiculo=" + year_vehiculo +
                ", caracteristica=" + caracteristica +
                ", links_imagen='" + links_imagen + '\'' +
                '}';
    }
}
