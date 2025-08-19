package dev.yolanda.views;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;

import dev.yolanda.dtos.MomentDTOResponse;
import dev.yolanda.models.Emotion;

public class HomeViewTest {
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private MockedStatic<HomeView> mockedHomeView;
   
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mockedHomeView = mockStatic(HomeView.class);
    }

    @Test
    void testViewAllMoments_Option2_MomentGetView() {

       LocalDate date = LocalDate.of(2025, 8, 13);
        MomentDTOResponse moment = new MomentDTOResponse(1, "Java", "Un día más sobreviviendo", Emotion.ANSIEDAD, date);

        MomentView.showAllMoments(List.of(moment));

        String output = outputStreamCaptor.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String expectedDate = date.format(formatter);

        assertThat(output, containsString("Lista de momentos vividos:"));
        assertThat(output, containsString("1. Ocurrió el: " + expectedDate));
        assertThat(output, containsString("Título: Java"));
        assertThat(output, containsString("Descripción: Un día más sobreviviendo"));
        assertThat(output, containsString("Emoción: ANSIEDAD"));
       
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
        mockedHomeView.close();
    }
}
