package dev.yolanda.db;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;

public class DiaryDataBaseTest {

    private DiaryDatabase db;

    @BeforeEach
    void setUp() {
        db = new DiaryDatabase();

        // Datos de prueba
        db.store(new Moment(1, "Cumpleaños", "Fiesta con amigos", Emotion.ALEGRIA, LocalDate.of(2025, 8, 14)));
        db.store(new Moment(2, "Entrega Proyecto Java", "No fue tan bien", Emotion.TRISTEZA, LocalDate.of(2025, 8, 10)));
        db.store(new Moment(3, "Vacaciones", "Playa y sol", Emotion.ALEGRIA, LocalDate.of(2025, 7, 20)));
    }

    @Test
    void testStoreAndGetAll() {
        List<Moment> allMoments = db.getAll();
        assertThat(allMoments, hasSize(3));
        assertThat(allMoments.get(1).getMomentTitle(), is("Entrega Proyecto Java"));
        assertThat(allMoments.get(2).getEmotion(), is(Emotion.ALEGRIA));
        assertThat(allMoments, hasItem(hasProperty("emotion", is(Emotion.ALEGRIA))));

    }

    @Test
    public void testDeleteMoment_removesCorrectMoment() {
        int idToDelete = db.getAll().get(1).getId(); // segundo momento insertado
        db.deleteMoment(idToDelete);

        List<Moment> allMoments = db.getAll();

        assertThat(allMoments, hasSize(2));
        assertThat(allMoments, everyItem(hasProperty("id", not(equalTo(idToDelete)))));
    }

    @Test
    public void testFilterByEmotion_returnsOnlyMatchingEmotion() {
        List<Moment> alegriaMoments = db.filterByEmotion(Emotion.ALEGRIA);

        assertThat(alegriaMoments, hasSize(2));
        assertThat(alegriaMoments, everyItem(hasProperty("emotion", is(Emotion.ALEGRIA))));
    }

    @Test
    public void testFilterByEmotion_noMatches_returnsEmptyList() {
        List<Moment> iraMoments = db.filterByEmotion(Emotion.IRA);
        assertThat(iraMoments, is(empty()));
    }

    @Test
    public void testFilterByDate_returnsMatchingMonthAndYear() {
        List<Moment> august2025 = db.filterByDate(8, 2025);

        assertThat(august2025, hasSize(2));
        assertThat(august2025, hasItems(
            hasProperty("momentTitle", is("Cumpleaños")),
            hasProperty("description", is("No fue tan bien"))
        ));
    }

    @Test
    public void testFilterByDate_noMatches_returnsEmptyList() {
        List<Moment> december2025 = db.filterByDate(12, 2025);
        assertThat(december2025, is(empty()));
    }
    
}
