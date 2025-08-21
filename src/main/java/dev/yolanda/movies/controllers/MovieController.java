package dev.yolanda.movies.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import dev.yolanda.movies.models.Movie;
import dev.yolanda.movies.repositories.MovieCsvRepository;

public class MovieController {
    private final MovieCsvRepository repo;

    public MovieController() {
        this.repo = new MovieCsvRepository(Path.of("data/movies.csv"));
    }

    public void addMovie(Movie movie) throws IOException {
        repo.save(movie);
    }

    public List<Movie> getAll() throws IOException {
        return repo.getAll();
    }

    public List<Movie> filterByGenre(String genre) throws IOException {
        return repo.getByGenre(genre);
    }
}
