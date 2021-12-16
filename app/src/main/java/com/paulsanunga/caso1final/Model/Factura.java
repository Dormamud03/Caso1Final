package com.paulsanunga.caso1final.Model;

import java.util.Date;
import java.util.List;

public class Factura {

    private Long id;
    private Date fecha_emision;
    private String descripcion;
    private String ruc_factura;
    private String nombre_empresa;
    private String direccion;
    private Client cliente;
    private List<DetalleFactura> detallesfacturas;

    public Factura() {
    }

    public Factura(Long id, Date fecha_emision, String descripcion, String ruc_factura, String nombre_empresa, String direccion, Client cliente, List<DetalleFactura> detallesfacturas) {
        this.id = id;
        this.fecha_emision = fecha_emision;
        this.descripcion = descripcion;
        this.ruc_factura = ruc_factura;
        this.nombre_empresa = nombre_empresa;
        this.direccion = direccion;
        this.cliente = cliente;
        this.detallesfacturas = detallesfacturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuc_factura() {
        return ruc_factura;
    }

    public void setRuc_factura(String ruc_factura) {
        this.ruc_factura = ruc_factura;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetallesfacturas() {
        return detallesfacturas;
    }

    public void setDetallesfacturas(List<DetalleFactura> detallesfacturas) {
        this.detallesfacturas = detallesfacturas;
    }
}
