package dev.yolanda.movies.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import dev.yolanda.models.Emotion;
import dev.yolanda.movies.models.Movie;

public class MovieCsvServices {

    private static final String HEADER = "imdbId,title,genres,emotion,releaseYear,createdAt";

    /**
     * Exporta las películas a un archivo CSV
     */
    public void export(List<Movie> movies, Path path) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER).append("\n");

        for (Movie movie : movies) {
            sb.append(escape(movie.getImdbId())).append(",");
            sb.append(escape(movie.getName())).append(",");
            sb.append(escape(String.join("|", movie.getGenres()))).append(",");
            sb.append(movie.getEmotion().name()).append(",");
            sb.append(movie.getReleaseYear()).append(",");
            sb.append(movie.getCreatedAt()).append("\n");
        }

        Files.createDirectories(path.getParent());
        Files.writeString(path, sb.toString());
    }

    /**
     * Importa las películas desde un archivo CSV
     */
    public List<Movie> importFrom(Path path) throws IOException {
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }

        List<String> lines = Files.readAllLines(path);
        if (lines.isEmpty()) return new ArrayList<>();

        return lines.stream()
                .skip(1) // saltamos cabecera
                .map(this::parseLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Movie parseLine(String line) {
        try {
            String[] parts = line.split(",", -1);

            String imdbId = unescape(parts[0]);
            String title = unescape(parts[1]);
            List<String> genres = Arrays.asList(unescape(parts[2]).split("\\|"));
            Emotion emotion = Emotion.valueOf(parts[3]);
            int releaseYear = Integer.parseInt(parts[4]);
            // createdAt lo dejamos como está en el CSV
            java.time.LocalDate createdAt = java.time.LocalDate.parse(parts[5]);

            Movie movie = new Movie(imdbId, title, genres, emotion, releaseYear);
            // ⚠️ en tu Movie actual, createdAt se asigna en el constructor
            // si quieres recuperar la fecha exacta desde CSV, deberíamos añadir un setter
            return movie;
        } catch (Exception e) {
            System.err.println("Error al parsear línea CSV: " + line + " -> " + e.getMessage());
            return null;
        }
    }

    // Escapa comas, comillas y saltos de línea para evitar romper el CSV
    private String escape(String s) {
        if (s == null) return "";
        boolean needQuotes = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");
        String escaped = s.replace("\"", "\"\"");
        return needQuotes ? "\"" + escaped + "\"" : escaped;
    }

    private String unescape(String s) {
        if (s == null) return "";
        s = s.trim();
        if (s.startsWith("\"") && s.endsWith("\"")) {
            s = s.substring(1, s.length() - 1).replace("\"\"", "\"");
        }
        return s;

    }
}
