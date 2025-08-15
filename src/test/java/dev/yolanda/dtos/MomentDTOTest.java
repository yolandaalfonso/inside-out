package dev.yolanda.dtos;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import dev.yolanda.models.Emotion;

public class MomentDTOTest {
    @Test
    void constructorAndGetters_shouldReturnExpectedValues() {
        LocalDate date = LocalDate.of(2025, 8, 15);

        MomentDTO dto = new MomentDTO(1, "Test", "Aprendiendo a testear", Emotion.ANSIEDAD, date);

        assertThat(dto.id(), is(1));
        assertThat(dto.momentTitle(), is("Test"));
        assertThat(dto.description(), is("Aprendiendo a testear"));
        assertThat(dto.emotion(), is(Emotion.ANSIEDAD));
        assertThat(dto.date(), is(date));
    }
}


