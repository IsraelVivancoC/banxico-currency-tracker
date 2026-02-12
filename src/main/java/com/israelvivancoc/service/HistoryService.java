package com.israelvivancoc.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoryService {

    public static Double getLastSavedRate(String fileName) {
        String lastLine = "";
        String currentLine;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((currentLine = br.readLine()) != null) {
                lastLine = currentLine; // Al final del ciclo, tendremos la última línea
            }

            if (!lastLine.isEmpty()) {
                // El CSV es: fecha,precio -> split(",")[1] nos da el precio
                String[] data = lastLine.split(",");
                return Double.parseDouble(data[1]);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            // Si el archivo no existe o está vacío, simplemente devolvemos null
            return null;
        }
        return null;
    }
}