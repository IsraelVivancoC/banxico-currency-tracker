package com.israelvivancoc.util;

import com.israelvivancoc.model.DataPoint;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvExporter {

    public static void exportToCsv(DataPoint data, String fileName) {
        // Usamos try-with-resources para que Java cierre el archivo automáticamente
        try (FileWriter fw = new FileWriter(fileName, true);
             PrintWriter pw = new PrintWriter(fw)) {

            // Si el archivo está vacío, podrías poner encabezados,
            // pero por ahora solo agregaremos la línea de datos
            pw.printf("%s,%s%n", data.getFecha(), data.getDato());

            System.out.println(" Data successfully exported to " + fileName);

        } catch (IOException e) {
            System.err.println(" Error writing to CSV: " + e.getMessage());
        }
    }
}