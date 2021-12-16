package com.paulsanunga.caso1final.Model;

public class Pais {

    private String cod_pais;
    private String nombre_pais;

    public Pais() {
    }

    public Pais(String cod_pais, String nombre_pais) {
        this.cod_pais = cod_pais;
        this.nombre_pais = nombre_pais;
    }

    public String getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(String cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }
}
