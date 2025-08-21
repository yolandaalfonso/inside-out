package dev.yolanda.movies.models;

import java.util.List;

import dev.yolanda.models.Emotion;

public class Movie {
    private String imdbId;
    private String title;
    private List<String> genres; // guardaremos en CSV separados por '|'
    private Emotion emotion;      // libre o podrías crear un enum Emotion
    private int releaseYear;

    public Movie(String imdbId, String title, List<String> genres, String emotion, int year) {
        this.imdbId = imdbId;
        this.title = title;
        this.genres = genres;
        this.emotion = emotion;
        this.releaseYear = releaseYear;
    }

    public String getImdbId() { return imdbId; }
    public String getTitle() { return title; }
    public List<String> getGenres() { return genres; }
    public String getEmotion() { return emotion; }
    public int getYear() { return releaseYear; }

    @Override public String toString() {
        return title + " (" + releaseYear + ") [" + String.join(", ", genres) + "]";
    }
}
