package com.paulsanunga.caso1final.Model;

public class CaracteristicaVehiculo {

    private Long idCaracteristica;
    private String eguridad;
    private String tecnologia;
    private int velocidades;
    private String interior;
    private String rines;
    private int cilindros;
    private String direccion;
    private String capacidadCarga;
    private String vidrios;
    private int numeroDePuertas;
    private String motor;

    public CaracteristicaVehiculo(Long idCaracteristica, String eguridad, String tecnologia, int velocidades, String interior, String rines, int cilindros, String direccion, String capacidadCarga, String vidrios, int numeroDePuertas, String motor) {
        this.idCaracteristica = idCaracteristica;
        this.eguridad = eguridad;
        this.tecnologia = tecnologia;
        this.velocidades = velocidades;
        this.interior = interior;
        this.rines = rines;
        this.cilindros = cilindros;
        this.direccion = direccion;
        this.capacidadCarga = capacidadCarga;
        this.vidrios = vidrios;
        this.numeroDePuertas = numeroDePuertas;
        this.motor = motor;
    }

    public CaracteristicaVehiculo() {
    }

    public Long getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Long idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getEguridad() {
        return eguridad;
    }

    public void setEguridad(String eguridad) {
        this.eguridad = eguridad;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(int velocidades) {
        this.velocidades = velocidades;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getRines() {
        return rines;
    }

    public void setRines(String rines) {
        this.rines = rines;
    }

    public int getCilindros() {
        return cilindros;
    }

    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(String capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

    public void setNumeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
}
