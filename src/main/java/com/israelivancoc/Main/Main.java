package com.israelivancoc;

import com.israelivancoc.service.BanxicoService;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        // 1. Cargamos el archivo .env desde la raíz del proyecto
        Dotenv dotenv = Dotenv.load();

        // 2. Obtenemos el token
        String token = dotenv.get("BANXICO_TOKEN");

        if (token == null || token.isEmpty()) {
            System.out.println(" ERROR: No se pudo encontrar el BANXICO_TOKEN en tu archivo .env");
        } else {
            System.out.println(" SUCCESS! Your .env file is connected.");

            // 3. ¡La magia ocurre aquí!
            // Creamos el servicio y le pasamos el token
            BanxicoService service = new BanxicoService(token);

            // Llamamos al método que consulta, traduce el JSON y muestra el precio
            service.fetchExchangeRate();
        }
    }
}