package dev.yolanda.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.yolanda.contracts.InterfaceDatabase;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;

public class MomentRepositoryTest {
    private InterfaceDatabase mockDb;
    private MomentRepository repository;

    @BeforeEach
    void setUp() {
        mockDb = mock(InterfaceDatabase.class);
        repository = new MomentRepository(mockDb);
    }

    @Test
    void testStoreMoment() {
        Moment moment = new Moment(
                1,
                "Cumpleaños",
                "Fiesta en casa",
                Emotion.ALEGRIA,
                LocalDate.of(2024, 5, 10)
        );

        repository.StoreMoment(moment);

        verify(mockDb, times(1)).store(moment);
    }

    @Test
    void testGetAllMoments() {
        Moment m1 = new Moment(1, "Titulo1", "Desc1", Emotion.ALEGRIA, LocalDate.now());
        Moment m2 = new Moment(2, "Titulo2", "Desc2", Emotion.TRISTEZA, LocalDate.now());

        when(mockDb.getAll()).thenReturn(Arrays.asList(m1, m2));

        List<Moment> result = repository.GetAllMoments();

        assertEquals(2, result.size());
        assertEquals("Titulo1", result.get(0).getMomentTitle());
        verify(mockDb, times(1)).getAll();
    }

    @Test
    void testDeleteMoment() {
        repository.deleteMoment(5);

        verify(mockDb, times(1)).deleteMoment(5);
    }

    @Test
    void testFilterByEmotion() {
        Moment m1 = new Moment(1, "Titulo1", "Desc1", Emotion.ALEGRIA, LocalDate.now());
        when(mockDb.filterByEmotion(Emotion.ALEGRIA)).thenReturn(Arrays.asList(m1));

        List<Moment> result = repository.filterByEmotion(Emotion.ALEGRIA);

        assertEquals(1, result.size());
        assertEquals(Emotion.ALEGRIA, result.get(0).getEmotion());
        verify(mockDb, times(1)).filterByEmotion(Emotion.ALEGRIA);
    }

    @Test
    void testFilterByDate() {
        Moment m1 = new Moment(1, "Titulo1", "Desc1", Emotion.ALEGRIA, LocalDate.of(2024, 5, 10));
        when(mockDb.filterByDate(5, 2024)).thenReturn(Arrays.asList(m1));

        List<Moment> result = repository.filterByDate(5, 2024);

        assertEquals(1, result.size());
        assertEquals(2024, result.get(0).getDate().getYear());
        verify(mockDb, times(1)).filterByDate(5, 2024);
    }

    @Test
    void testFilterByDate_emptyResults() {
        when(mockDb.filterByDate(12, 1999)).thenReturn(Collections.emptyList());

        List<Moment> result = repository.filterByDate(12, 1999);

        assertTrue(result.isEmpty());
        verify(mockDb, times(1)).filterByDate(12, 1999);
    }
}
