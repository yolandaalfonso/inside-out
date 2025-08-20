package dev.yolanda.views;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.InputStream;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Test;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.models.Mood;

public class FilterDateViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testFilterByDate_withResults() {
        // Simulamos entrada del usuario: mes=5, año=2024
        String input = "5\n2024\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Mock Controller
        MomentController mockController = mock(MomentController.class);
        FilterDateView.setController(mockController); // inyectamos mock

        // Creamos un momento válido
        Moment m1 = new Moment(0, "Un día especial", "Descripción...", Emotion.ALEGRIA, 
                               LocalDate.of(2024, 5, 1), Mood.BUENO);

        when(mockController.getMomentsByDate(5, 2024)).thenReturn(List.of(m1));

        // Ejecutamos método
        List<Moment> result = FilterDateView.filterByDate();

        // Verificamos que se devolvió la lista mockeada
        assertEquals(1, result.size());
        assertEquals("Un día especial", result.get(0).getMomentTitle());

        // Verificamos salida por consola
        String output = outContent.toString();
        assertTrue(output.contains("Lista de momentos vividos:"));
        assertTrue(output.contains("Un día especial"));
    }

    @Test
    void testFilterByDate_noResults() {
        // Entrada del usuario: mes=6, año=2024
        String input = "6\n2024\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Mock Controller
        MomentController mockController = mock(MomentController.class);
        FilterDateView.setController(mockController);

        when(mockController.getMomentsByDate(6, 2024)).thenReturn(Collections.emptyList());

        List<Moment> result = FilterDateView.filterByDate();

        // Debe devolver lista vacía
        assertTrue(result.isEmpty());

        // Verificamos salida
        String output = outContent.toString();
        assertTrue(output.contains("No hay momentos con esa fecha."));
    }
}
