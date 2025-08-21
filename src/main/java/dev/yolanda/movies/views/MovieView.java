package dev.yolanda.movies.views;

import dev.yolanda.movies.controllers.MovieController;
import dev.yolanda.movies.models.Movie;
import dev.yolanda.movies.services.MovieService;
import dev.yolanda.views.HomeView;
import dev.yolanda.views.View;

public class MovieView extends View{
    private static final MovieController MOVIE_CONTROLLER = new MovieController();
    // Pon tu key real aquí o pásala por configuración
    private static final MovieService API = new MovieService("TU_API_KEY");

    public static void printMenu() {
        try {
            System.out.println("IMDB id (ej: tt0118583):");
            String imdbId = SCANNER.nextLine().trim();

            System.out.println("Emoción que te provocó:");
            String emotion = SCANNER.nextLine().trim();

            Movie movie = API.fetchByImdbId(imdbId, emotion);
            MOVIE_CONTROLLER.addMovie(movie);
            System.out.println("Película guardada desde la API: " + movie);
        } catch (Exception e) {
            System.out.println("No se pudo añadir la película: " + e.getMessage());
        }
        HomeView.printMenu();
    }
}
