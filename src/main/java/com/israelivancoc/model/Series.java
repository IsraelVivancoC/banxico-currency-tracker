package com.israelivancoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {
    private List<DataPoint> datos;

    public List<DataPoint> getDatos() { return datos; }
    public void setDatos(List<DataPoint> datos) { this.datos = datos; }
}