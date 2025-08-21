package dev.yolanda.movies.repositories;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import dev.yolanda.movies.models.Movie;
import dev.yolanda.services.CsvUtils;

public class MovieCsvRepository {
    private List<Movie> movies;

    public MovieRepositoryCSV() {
        this.movies = new ArrayList<>();
    }

    public void save(Movie movie) {
        this.movies.add(movie);
        System.out.println("Película guardada en CSV: " + movie.getName());
    }
    
    public void exportMoviesCSV(String filePath) {

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Título,Género/s,Emoción,Estreno,Creación\n");

            for(Movie movie : this.movies) {
                writer.append(movie.getName());
                writer.append(",");
                writer.append(String.join("|", movie.getGenres()));
                writer.append(",");
                writer.append(movie.getEmotion().name());
                writer.append(",");
                writer.append(movie.getReleaseYear());
                writer.append(",");
                writer.append(movie.getCreationDate());
                writer.append("\n");
            }
            System.out.println("Archivo CSV generado exitosamente en: " + filePath);

        }catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
