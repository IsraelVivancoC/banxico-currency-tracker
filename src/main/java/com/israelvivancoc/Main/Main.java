package com.israelvivancoc;

import com.israelvivancoc.model.DataPoint;
import com.israelvivancoc.service.BanxicoService;
import com.israelvivancoc.service.HistoryService; // Nuevo import
import com.israelvivancoc.util.CsvExporter;
import com.israelvivancoc.util.CurrencyConverter;
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
                // 1. PEDIMOS EL PRECIO ANTERIOR (Antes de guardar el nuevo)
                Double lastRate = HistoryService.getLastSavedRate("banxico_history.csv");
                double currentRate = Double.parseDouble(todayData.getDato());

                // COMPARATIVA
                System.out.println(" --- MARKET COMPARISON ---");
                if (lastRate != null) {
                    double difference = currentRate - lastRate;
                    String trend = (difference >= 0) ? " UP (+" : " DOWN (";
                    System.out.printf("Last saved rate: $%.4f%n", lastRate);
                    System.out.printf("Trend: %s%.4f) compared to last record.%n", trend, difference);
                } else {
                    System.out.println("No historical data found to compare.");
                }
                System.out.println("-----------------------------\n");

                // GUARDA HISTORIAL
                CsvExporter.exportToCsv(todayData, "banxico_history.csv");

                // 4. CONVERSOR
                CurrencyConverter.showConversionMenu(todayData);
            }
        }
    }
}