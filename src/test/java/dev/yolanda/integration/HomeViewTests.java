package dev.yolanda.integration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.yolanda.views.HomeView;

public class HomeViewTests {
    private final InputStream inputPrintStream = System.in;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Test de integración de HomeView.printMenu()
    @Test
    void testPrintMenu_SelectOption1() {

        String titleRequest = "Ingrese el título:";
        String dateRequest = "Ingresa la fecha (dd/mm/year):";
        String descriptionRequest = "Ingrese la descripción:";
        String confirmacion = "Momento vivido añadido correctamente.";
        
        String input = String.format("%s\n%s\n%s\n%s2", "1", "Un día aprendiendo Java", "12/02/2025", "otro día horrible", "5");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        HomeView.printMenu();

        assertThat(outputStreamCaptor.toString().trim(), containsString(titleRequest));
        assertThat(outputStreamCaptor.toString().trim(), containsString(dateRequest));
        assertThat(outputStreamCaptor.toString().trim(), containsString(descriptionRequest));
        assertThat(outputStreamCaptor.toString().trim(), containsString("Momento vivido añadido correctamente."));
    }

    @AfterEach
    void tearDown() {
        System.setIn(inputPrintStream);
        System.setOut(printStream);
    }
}
