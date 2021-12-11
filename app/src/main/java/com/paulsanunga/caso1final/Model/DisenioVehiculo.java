package com.paulsanunga.caso1final.Model;

public class DisenioVehiculo {

    private long id_diseno;
    private String marca;
    private String modelo;

    public DisenioVehiculo() {
    }

    public DisenioVehiculo(long id_diseno, String marca, String modelo) {
        this.id_diseno = id_diseno;
        this.marca = marca;
        this.modelo = modelo;
    }

    public long getId_diseno() {
        return id_diseno;
    }

    public void setId_diseno(long id_diseno) {
        this.id_diseno = id_diseno;
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
