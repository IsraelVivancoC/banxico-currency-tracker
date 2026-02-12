package com.israelvivancoc;

import com.israelvivancoc.model.DataPoint;
import com.israelvivancoc.service.BanxicoService;
import com.israelvivancoc.service.HistoryService;
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
                // OBTENER PRECIO ANTERIOR (Esto ignorando los registros de hoy)
                Double lastRate = HistoryService.getLastSavedRate("banxico_history.csv", todayData.getFecha());
                double currentRate = Double.parseDouble(todayData.getDato());

                //  COMPARATIVA
                System.out.println("\n --- MARKET COMPARISON ---");
                System.out.println("Official Rate Today: $" + currentRate);

                if (lastRate != null) {
                    double difference = currentRate - lastRate;
                    // Ternario para emojis y texto de tendencia
                    String trendEmoji = (difference >= 0) ? " UP" : " DOWN";
                    System.out.printf("Yesterday's rate:     $%.4f%n", lastRate);
                    System.out.printf("Trend:               %s (%+.4f)%n", trendEmoji, difference);
                } else {
                    System.out.println("No previous historical data available for comparison.");
                }
                System.out.println("-----------------------------\n");

                // GUARDAR HISTORIAL
                CsvExporter.exportToCsv(todayData, "banxico_history.csv");

                //  CONVERSOR INTERACTIVO
                CurrencyConverter.showConversionMenu(todayData);
            }
        }
    }
}