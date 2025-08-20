package dev.yolanda.views;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Scanner;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import dev.yolanda.controllers.MomentController;eEach;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class MomentDeleteViewTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private MockedStatic<MomentControllerSingleton> mockedControllerSingleton;
    private MockedStatic<HomeView> mockedHomeView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mockedControllerSingleton = mockStatic(MomentControllerSingleton.class);
        mockedHomeView = mockStatic(HomeView.class);
    }

    @Test
    void testDeleteMoment_Option3() {
        // Mock Controller
        MomentController mockController = mock(MomentController.class);
        mockedControllerSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

        // Simulamos entrada de usuario
        String inputId = "1\n";
        System.setIn(new ByteArrayInputStream(inputId.getBytes()));
        View.SCANNER = new Scanner(System.in);

        // Ejecutamos método de la vista
        MomentDeleteView.printDeleteMenu();

        // Verificamos interacción con controller
        verify(mockController).deleteMoment(1); 

        // Verificamos salida en consola
        String output = outputStreamCaptor.toString();
        assertThat(output, containsString("Ingresa el identificador del momento:"));
        assertThat(output, containsString("Momento vivido eliminado correctamente"));

        // Verificamos que se llamó al menú principal
        mockedHomeView.verify(() -> HomeView.printMenu());
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        mockedControllerSingleton.close();
        mockedHomeView.close();
        View.SCANNER.close(); 
    }
}
