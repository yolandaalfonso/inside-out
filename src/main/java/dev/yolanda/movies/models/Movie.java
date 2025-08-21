package dev.yolanda.movies.models;

import java.time.LocalDate;
import java.util.List;

import dev.yolanda.models.Emotion;

public class Movie {
    private String imdbId;
    private String title;
    private List<String> genres; // guardaremos en CSV separados por '|'
    private Emotion emotion; 
    private List<Integer> releaseYears;
    private LocalDate createdAt;

    public Movie(String imdbId, String title, List<String> genres, Emotion emotion, int releaseYear) {
        this.imdbId = imdbId;
        this.title = title;
        this.genres = genres;
        this.emotion = emotion;
        this.releaseYears = releaseYears;
        this.createdAt = LocalDate.now();
    }

    public String getImdbId() { return imdbId; }
    public String getTitle() { return title; }
    public List<String> getGenres() { return genres; }
    public Emotion getEmotion() { return emotion; }
    public List<Integer> getReleaseYears() { return releaseYears; }
    public LocalDate getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return title + " (" + releaseYears + ") [" + String.join(", ", genres) + "] - " + emotion;
    }
}
