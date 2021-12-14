package com.paulsanunga.caso1final.Model;

public class Vehiculo {

    private String chasis_vehiculo;
    private String color;
    private String ramv;
    private boolean estado;
    private Pais id_pais;
    private GarantiaVehiculo id_garantia;
    private CatalogoVehiculos vehiculoCatalogo;
    private Double precio_compra;
    private Double precio_venta;

    public Vehiculo() {
    }

    public Vehiculo(String chasis_vehiculo, String color, String ramv, boolean estado, Pais id_pais, GarantiaVehiculo id_garantia, CatalogoVehiculos vehiculoCatalogo, Double precio_compra, Double precio_venta) {
        this.chasis_vehiculo = chasis_vehiculo;
        this.color = color;
        this.ramv = ramv;
        this.estado = estado;
        this.id_pais = id_pais;
        this.id_garantia = id_garantia;
        this.vehiculoCatalogo = vehiculoCatalogo;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public String getChasis_vehiculo() {
        return chasis_vehiculo;
    }

    public void setChasis_vehiculo(String chasis_vehiculo) {
        this.chasis_vehiculo = chasis_vehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRamv() {
        return ramv;
    }

    public void setRamv(String ramv) {
        this.ramv = ramv;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Pais getId_pais() {
        return id_pais;
    }

    public void setId_pais(Pais id_pais) {
        this.id_pais = id_pais;
    }

    public GarantiaVehiculo getId_garantia() {
        return id_garantia;
    }

    public void setId_garantia(GarantiaVehiculo id_garantia) {
        this.id_garantia = id_garantia;
    }

    public CatalogoVehiculos getVehiculoCatalogo() {
        return vehiculoCatalogo;
    }

    public void setVehiculoCatalogo(CatalogoVehiculos vehiculoCatalogo) {
        this.vehiculoCatalogo = vehiculoCatalogo;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }
}
