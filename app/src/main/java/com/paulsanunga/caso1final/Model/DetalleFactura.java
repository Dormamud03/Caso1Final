package com.paulsanunga.caso1final.Model;

public class DetalleFactura {

    private Long id;
    private Integer cantidad;
    private Double total;
    private Vehiculo vehiculo;

    public DetalleFactura(Long id, Integer cantidad, Double total, Vehiculo vehiculo) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.vehiculo = vehiculo;
    }

    public DetalleFactura() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
