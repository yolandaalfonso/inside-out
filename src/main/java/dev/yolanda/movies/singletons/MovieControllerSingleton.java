package dev.yolanda.movies.singletons;

import dev.yolanda.movies.controllers.MovieController;

public class MovieControllerSingleton {
    private static final MovieController INSTANCE = new MovieController();

    private MovieControllerSingleton() {}
    
    public static MovieController getInstance() {
        return INSTANCE;
    }
}
