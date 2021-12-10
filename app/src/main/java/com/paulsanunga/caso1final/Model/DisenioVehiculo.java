package com.paulsanunga.caso1final.Model;

public class DisenioVehiculo {

    private Long idDiseno;
    private String marca;
    private String modelo;

    public DisenioVehiculo() {
    }

    public DisenioVehiculo(Long idDiseno, String marca, String modelo) {
        this.idDiseno = idDiseno;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getIdDiseno() {
        return idDiseno;
    }

    public void setIdDiseno(Long idDiseno) {
        this.idDiseno = idDiseno;
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
