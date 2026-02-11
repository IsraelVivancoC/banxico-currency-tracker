package com.israelvivancoc;

import com.israelvivancoc.model.DataPoint; // Import necesario
import com.israelvivancoc.service.BanxicoService;
import com.israelvivancoc.util.CsvExporter; // Import necesario
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("BANXICO_TOKEN");

        if (token == null || token.isEmpty()) {
            System.out.println(" ERROR: No se pudo encontrar el BANXICO_TOKEN en tu archivo .env");
        } else {
            System.out.println(" SUCCESS! Your .env file is connected.");

            BanxicoService service = new BanxicoService(token);

            // Capturamos el resultado del servicio
            DataPoint todayData = service.fetchExchangeRate();

            // Si se obtienen datos, los guardamos en el CSV
            if (todayData != null) {
                CsvExporter.exportToCsv(todayData, "banxico_history.csv");
            }
        }
    }
}