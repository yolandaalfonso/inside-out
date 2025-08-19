package dev.yolanda.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

public class FilterEmotionViewTest {
    
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        // Capturar System.out
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @BeforeEach
    void resetScanner() {
    String input = "1\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    // recrear el Scanner si lo has cerrado antes
    FilterEmotionView.SCANNER = new Scanner(System.in); // si es accesible
}


    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void testFilterByEmotion_validOption_withResults() {
        // Simular input del usuario -> selecciona emoción "1" (ALEGRIA)
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Mock de MomentController
        MomentController mockController = mock(MomentController.class);

        Moment moment = new Moment(
        1,
        "Cumpleaños",
        "Fiesta en casa",
        Emotion.ALEGRIA,
        LocalDate.of(2024, 5, 10)
        );

        when(mockController.getMomentsByEmotion(Emotion.ALEGRIA))
                .thenReturn(Arrays.asList(moment));

        try (MockedStatic<MomentControllerSingleton> mockedSingleton = mockStatic(MomentControllerSingleton.class)) {
            mockedSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

            List<Moment> result = FilterEmotionView.filterByEmotion();

            assertEquals(1, result.size());
            assertEquals("Cumpleaños", result.get(0).getMomentTitle());

            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("Lista de momentos vividos:"));
            assertTrue(consoleOutput.contains("Cumpleaños"));
        }
    }

    @Test
    void testFilterByEmotion_validOption_noResults() {
        // Input del usuario -> emoción "2" (TRISTEZA)
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MomentController mockController = mock(MomentController.class);
        when(mockController.getMomentsByEmotion(Emotion.TRISTEZA))
                .thenReturn(Collections.emptyList());

        try (MockedStatic<MomentControllerSingleton> mockedSingleton = mockStatic(MomentControllerSingleton.class)) {
            mockedSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

            List<Moment> result = FilterEmotionView.filterByEmotion();

            assertTrue(result.isEmpty());

            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("No hay momentos con esa emoción."));
        }
    }

    @Test
    void testFilterByEmotion_invalidOption() {
        // Input del usuario -> opción inválida "99"
        String input = "99\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        MomentController mockController = mock(MomentController.class);
        try (MockedStatic<MomentControllerSingleton> mockedSingleton = mockStatic(MomentControllerSingleton.class)) {
            mockedSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

            List<Moment> result = FilterEmotionView.filterByEmotion();

            assertTrue(result.isEmpty());

            String consoleOutput = outputStream.toString();
            assertTrue(consoleOutput.contains("Opción inválida"));
        }
    }
    
}
