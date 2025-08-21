package dev.yolanda.movies.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.yolanda.movies.DAO.ApiMoviesDAO;
import dev.yolanda.movies.dtos.MovieDTO;

public class MovieService {
    public MovieService(ApiMoviesDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
    
    private final ApiMoviesDAO movieDAO;

    public MovieDTO findMovieById(String imdbId) {
        String movieData = movieDAO.getMovie(imdbId);

        if(movieData != null && !movieData.isEmpty()) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(movieData, MovieDTO.class);
        }
        return null;
    }
}
