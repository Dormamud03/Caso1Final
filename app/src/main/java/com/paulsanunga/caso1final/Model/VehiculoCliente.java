package com.paulsanunga.caso1final.Model;

public class VehiculoCliente {

    private String chasis_vehiculo;
    private String links_imagen;
    private String marca;
    private String modelo;

    public VehiculoCliente() {
    }

    public VehiculoCliente(String chasis_vehiculo, String links_imagen, String marca, String modelo) {
        this.chasis_vehiculo = chasis_vehiculo;
        this.links_imagen = links_imagen;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getChasis_vehiculo() {
        return chasis_vehiculo;
    }

    public void setChasis_vehiculo(String chasis_vehiculo) {
        this.chasis_vehiculo = chasis_vehiculo;
    }

    public String getLinks_imagen() {
        return links_imagen;
    }

    public void setLinks_imagen(String links_imagen) {
        this.links_imagen = links_imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
