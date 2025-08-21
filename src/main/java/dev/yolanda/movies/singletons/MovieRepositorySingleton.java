package dev.yolanda.movies.singletons;

import dev.yolanda.movies.repositories.MovieCsvRepository;

public class MovieRepositorySingleton {

    private static MovieCsvRepository INSTANCE;

    private MovieRepositorySingleton() {}

    public static MovieCsvRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieCsvRepository();
        }
        return INSTANCE;
    }
}
