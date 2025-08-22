package dev.yolanda.movies.views;

import dev.yolanda.models.Emotion;
import dev.yolanda.movies.controllers.MovieController;
import dev.yolanda.movies.singletons.MovieControllerSingleton;
import dev.yolanda.views.HomeView;
import dev.yolanda.views.View;

public class MovieView extends View{

    private static MovieController getController() {
        return MovieControllerSingleton.getInstance();
    }

    /*private static final MovieController MOVIE_CONTROLLER = new MovieController();
    // ¿Para que tengo que poner aquí mi API Key?
    private static final MovieService API = new MovieService("TU_API_KEY");*/

    public static void printMenu() {
        try {
            System.out.println("IMDB id (ej: tt0118583):");
            String imdbId = SCANNER.nextLine().trim();

            /*System.out.println("Emoción que te provocó:");
            String emotion = SCANNER.nextLine().trim();*/
            String text = """
                Selecciona una emoción que te provocó:
                1. Alegría
                2. Tristeza
                3. Ira
                4. Asco
                5. Miedo
                6. Ansiedad
                7. Envidia
                8. Vergüenza
                9. Aburrimiento
                10. Nostalgia
                """;

        System.out.print(text);
        int numberEmotion = SCANNER.nextInt();
        SCANNER.nextLine();

        Emotion emotion = Emotion.values()[numberEmotion - 1];
            

            //Movie movie = API.fetchByImdbId(imdbId, emotion);
            getController().addMovieById(imdbId, emotion);
            System.out.println("Película guardada con éxito.");
        } catch (Exception e) {
            System.out.println("No se pudo añadir la película: " + e.getMessage());
        }
        HomeView.printMenu();
    }
}
