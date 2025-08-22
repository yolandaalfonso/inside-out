package dev.yolanda.movies.mappers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import dev.yolanda.models.Emotion;
import dev.yolanda.movies.dtos.MovieDTO;
import dev.yolanda.movies.models.Movie;

public class MovieMapper {
    public static Movie toEntity(MovieDTO dto, Emotion emotion, LocalDate creationDate) {

        String name = dto.getShortInfo().getName();
        String[] genresArray = dto.getShortInfo().getGenre();
        String releaseYear = dto.getShortInfo().getReleaseYear();
        String imdbId = dto.getImdbId();
        
        List<String> genresList = Arrays.asList(genresArray);
        
        int id = 0;
        try {
            id = Integer.parseInt(imdbId);
        } catch (NumberFormatException e) {
            // Por si el ID no es un número
        }
        return new Movie(id, name, genresList, emotion, releaseYear, createdAt.toString());
    }
    
}
