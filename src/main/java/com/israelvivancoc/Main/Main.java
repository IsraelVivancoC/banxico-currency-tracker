package com.israelvivancoc;

import com.israelvivancoc.model.DataPoint;
import com.israelvivancoc.service.BanxicoService;
import com.israelvivancoc.util.CsvExporter;
import com.israelvivancoc.util.CurrencyConverter; // Nuestro nuevo import
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("BANXICO_TOKEN");

        if (token == null || token.isEmpty()) {
            System.out.println(" ERROR: No se pudo encontrar el BANXICO_TOKEN");
        } else {
            System.out.println(" SUCCESS! Your .env file is connected.");

            BanxicoService service = new BanxicoService(token);
            DataPoint todayData = service.fetchExchangeRate();

            if (todayData != null) {
                // Guarda el historial
                CsvExporter.exportToCsv(todayData, "banxico_history.csv");

                // Interacción con el usuario
                CurrencyConverter.showConversionMenu(todayData);
            }
        }
    }
}