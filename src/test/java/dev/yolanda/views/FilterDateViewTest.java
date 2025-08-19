package dev.yolanda.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.singletons.MomentControllerSingleton;

public class FilterDateViewTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        // Capturar System.out
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void testFilterByDate_withResults() {
        // Simular input del usuario: mes=5, año=2024
        String input = "5\n2024\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Mock del controller
        MomentController mockController = mock(MomentController.class);
        Moment moment = new Moment(
                1,
                "Cumpleaños",
                "Fiesta en casa",
                Emotion.ALEGRIA,
                LocalDate.of(2024, 5, 10)
        );

        when(mockController.getMomentsByDate(5, 2024))
                .thenReturn(Arrays.asList(moment));

        try (MockedStatic<MomentControllerSingleton> mockedSingleton = mockStatic(MomentControllerSingleton.class)) {
            mockedSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

            List<Moment> result = FilterDateView.filterByDate();

            assertEquals(1, result.size());
            assertEquals("Cumpleaños", result.get(0).getMomentTitle());

            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("Lista de momentos vividos:"));
            assertTrue(consoleOutput.contains("Cumpleaños"));
        }
    }

    @Test
    void testFilterByDate_noResults() {
        // Simular input del usuario: mes=12, año=2025
        String input = "12\n2025\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Mock del controller
        MomentController mockController = mock(MomentController.class);
        when(mockController.getMomentsByDate(12, 2025))
                .thenReturn(Collections.emptyList());

        try (MockedStatic<MomentControllerSingleton> mockedSingleton = mockStatic(MomentControllerSingleton.class)) {
            mockedSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

            List<Moment> result = FilterDateView.filterByDate();

            assertTrue(result.isEmpty());

            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("No hay momentos con esa fecha."));
        }
    }
}
