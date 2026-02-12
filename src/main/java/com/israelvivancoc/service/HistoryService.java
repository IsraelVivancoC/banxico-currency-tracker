package com.israelvivancoc.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoryService {

    public static Double getLastSavedRate(String fileName, String todayDate) {
        String lastDifferentRate = null;
        String currentLine;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((currentLine = br.readLine()) != null) {
                String[] data = currentLine.split(",");
                // Si la fecha de la línea es distinta a la de hoy, la guardamos
                if (data.length >= 2 && !data[0].equals(todayDate)) {
                    lastDifferentRate = data[1];
                }
            }

            return (lastDifferentRate != null) ? Double.parseDouble(lastDifferentRate) : null;

        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return null;
        }
    }
}