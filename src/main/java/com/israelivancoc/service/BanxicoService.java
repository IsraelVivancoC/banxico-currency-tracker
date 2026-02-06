package com.israelivancoc.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BanxicoService {
    private final String token;
    private final HttpClient client;

    public BanxicoService(String token) {
        this.token = token;
        this.client = HttpClient.newHttpClient();
    }

    public void fetchExchangeRate() {
        // Esta es la URL para el tipo de cambio USD/MXN de hoy
        String url = "https://www.banxico.org.mx/SieAPIRest/service/v1/series/SF43718/datos/oportuno";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Bmx-Token", token) // Aquí es donde usamos tu secreto del .env
                .GET()
                .build();

        System.out.println(" Consultando a Banxico...");
    }
}