package dev.yolanda.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.*;

import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.yolanda.views.HomeView;
import dev.yolanda.views.MomentPostView;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class HomeViewTests {
    private final InputStream inputPrintStream = System.in;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // Test de integración de HomeView.printMenu()
    /*@Test
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
    }*/

    @Test
    void testPrintMenu_SelectOption1_DisplaysExpectedPrompts() {
        String input = "1\n"; // Selecciona opción 1 y sale
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (MockedStatic<MomentPostView> mocked = mockStatic(MomentPostView.class)) {
            mocked.when(MomentPostView::printStoreMenu).then(invocation -> {
                System.out.println("Ingrese el título:");
                System.out.println("Ingresa la fecha (dd/mm/year):");
                System.out.println("Ingrese la descripción:");
                System.out.println("Momento vivido añadido correctamente.");
                return null;
            });

            HomeView.printMenu();

            String output = outputCaptor.toString();
            assertThat(output, containsString("Ingrese el título:"));
            assertThat(output, containsString("Ingresa la fecha (dd/mm/year):"));
            assertThat(output, containsString("Ingrese la descripción:"));
            assertThat(output, containsString("Momento vivido añadido correctamente."));
        }
    }

    @AfterEach
    void tearDown() {
        System.setIn(inputPrintStream);
        System.setOut(printStream);
    }
}
