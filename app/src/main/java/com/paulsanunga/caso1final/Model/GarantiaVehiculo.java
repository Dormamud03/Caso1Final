package com.paulsanunga.caso1final.Model;

public class GarantiaVehiculo {

    private Integer id_garantia;
    private String descripcion;

    public GarantiaVehiculo() {
    }

    public GarantiaVehiculo(Integer id_garantia, String descripcion) {
        this.id_garantia = id_garantia;
        this.descripcion = descripcion;
    }

    public Integer getId_garantia() {
        return id_garantia;
    }

    public void setId_garantia(Integer id_garantia) {
        this.id_garantia = id_garantia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
