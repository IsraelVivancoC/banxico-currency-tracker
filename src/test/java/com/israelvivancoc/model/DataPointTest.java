package com.israelvivancoc.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataPointTest {

    @Test
    public void testDataPointGettersAndSetters() {
        // Datos de prueba
        DataPoint point = new DataPoint();
        String expectedFecha = "09/02/2026";
        String expectedDato = "17.25";

        // Ejecuta los métodos del POJO
        point.setFecha(expectedFecha);
        point.setDato(expectedDato);

        // Verificamos que el POJO guardó y devolvió lo correcto
        assertEquals(expectedFecha, point.getFecha(), "La fecha guardada no coincide con la esperada");
        assertEquals(expectedDato, point.getDato(), "El valor guardado no coincide con el esperado");
    }
}