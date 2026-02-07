package com.israelivancoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BanxicoResponse {
    // Banxico manda un objeto "bmx" que contiene una lista de "series"
    private Map<String, List<Series>> bmx;

    public Map<String, List<Series>> getBmx() { return bmx; }
    public void setBmx(Map<String, List<Series>> bmx) { this.bmx = bmx; }
}