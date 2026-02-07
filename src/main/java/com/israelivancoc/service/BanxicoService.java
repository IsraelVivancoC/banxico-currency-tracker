package com.israelivancoc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.israelivancoc.model.BanxicoResponse;
import com.israelivancoc.model.DataPoint;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BanxicoService {
    private final String token;
    private final HttpClient client;
    private final ObjectMapper mapper; // El traductor de JSON

    public BanxicoService(String token) {
        this.token = token;
        this.client = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    public void fetchExchangeRate() {
        String url = "https://www.banxico.org.mx/SieAPIRest/service/v1/series/SF43718/datos/oportuno";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Bmx-Token", token)
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Aquí ocurre la magia de Jackson
                BanxicoResponse result = mapper.readValue(response.body(), BanxicoResponse.class);

                // Navegamos por el "laberinto" del JSON de Banxico
                DataPoint lastPoint = result.getBmx().get("series").get(0).getDatos().get(0);

                System.out.println("------------------------------------------");
                System.out.println(" TIPO DE CAMBIO (Banxico FIX)");
                System.out.println("Fecha: " + lastPoint.getFecha());
                System.out.println("Precio: $" + lastPoint.getDato() + " MXN");
                System.out.println("------------------------------------------");
            } else {
                System.out.println(" Error del servidor: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println(" Error al procesar datos: " + e.getMessage());
            e.printStackTrace(); // Esto ayuda a ver si Jackson falló en algo
        }
    }
}