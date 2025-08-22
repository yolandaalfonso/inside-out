package dev.yolanda.movies.controllers;

import java.time.LocalDate;

import dev.yolanda.models.Emotion;
import dev.yolanda.movies.dtos.MovieDTO;
import dev.yolanda.movies.mappers.MovieMapper;
import dev.yolanda.movies.models.Movie;
import dev.yolanda.movies.repositories.MovieCsvRepository;
import dev.yolanda.movies.services.MovieService;
import dev.yolanda.movies.singletons.MovieRepositorySingleton;

public class MovieController {
    private final MovieCsvRepository repository;
    private final MovieService movieService;

    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
        this.movieService = new MovieService(null);
    }

    public void addMovieById(String imdbId, Emotion emotion) {
        MovieDTO movieDTO = movieService.findMovieById(imdbId);

        if(movieDTO != null) {
            LocalDate creationDate = LocalDate.now();
            Movie movie = MovieMapper.toEntity(movieDTO, emotion, creationDate);

            repository.save(movie);
            System.out.print("Película añadida con éxito!");
        } else {
            System.out.println("No se encontró la peli. Inténtalo de nuevo.");
        }

    }
}
