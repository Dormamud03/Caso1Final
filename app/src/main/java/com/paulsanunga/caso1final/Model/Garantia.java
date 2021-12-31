package com.paulsanunga.caso1final.Model;

import java.util.Date;

public class Garantia {
    private Long id_solicitud;
    private String fecha_solicitud;
    private String descripcion;

    public Garantia() {
    }

    public Garantia(Long id_solicitud, String fecha_solicitud, String descripcion) {
        this.id_solicitud = id_solicitud;
        this.fecha_solicitud = fecha_solicitud;
        this.descripcion = descripcion;
    }

    public Long getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(Long id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
