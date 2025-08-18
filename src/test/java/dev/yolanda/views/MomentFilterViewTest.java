package dev.yolanda.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;

public class MomentFilterViewTest {
    private final InputStream inputPrintStream = System.in;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); 

    private MockedStatic<FilterEmotionView> mockedFilterEmotionView;
    private MockedStatic<HomeView> mockedHomeView;


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mockedFilterEmotionView = mockStatic(FilterEmotionView.class);
        mockedHomeView = mockStatic(HomeView.class);

    }

    @Test
    void testFilterViewMenu_Option4() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View.SCANNER = new Scanner(System.in);

        MomentFilterView.printFilterMenu();

        mockedFilterEmotionView.verify(FilterEmotionView::filterByEmotion);

        String output = outputStreamCaptor.toString();
        assertThat(output, containsString("Filtrar por..."));

        mockedHomeView.verify(HomeView::printMenu);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(inputPrintStream);
        System.setOut(printStream);
        mockedFilterEmotionView.close();
        mockedHomeView.close();
        View.SCANNER.close();
    }
}
