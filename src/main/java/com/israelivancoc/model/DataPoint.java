package com.israelivancoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPoint {
    private String fecha;
    private String dato;

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getDato() { return dato; }
    public void setDato(String dato) { this.dato = dato; }
}