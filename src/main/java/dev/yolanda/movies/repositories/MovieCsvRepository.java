package dev.yolanda.movies.repositories;

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
    private final Path file;

    public MovieCsvRepository(Path file) {
        this.file = file;
    }

    public void save(Movie movie) throws IOException {
        Files.createDirectories(file.getParent());
        if (Files.notExists(file)) {
            Files.writeString(file, "imdbId,title,genres,emotion,year\n");
        }
        String line = String.join(",",
                CsvUtils.escape(movie.getImdbId()),
                CsvUtils.escape(movie.getTitle()),
                CsvUtils.escape(String.join("|", movie.getGenres())),
                CsvUtils.escape(movie.getEmotion()),
                Integer.toString(movie.getYear())
        );
        Files.writeString(file, line + "\n", StandardOpenOption.APPEND);
    }

    public List<Movie> getAll() throws IOException {
        if (Files.notExists(file)) return Collections.emptyList();
        List<String> lines = Files.readAllLines(file);
        if (lines.isEmpty()) return Collections.emptyList();
        return lines.stream()
                .skip(1) // cabecera
                .filter(l -> !l.isBlank())
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    public List<Movie> getByGenre(String genre) throws IOException {
        String g = genre.trim().toLowerCase();
        return getAll().stream()
                .filter(m -> m.getGenres().stream().anyMatch(x -> x.equalsIgnoreCase(g) || x.toLowerCase().equals(g)))
                .collect(Collectors.toList());
    }

    private Movie parseLine(String line) {
        // CSV simple: split por comas respetando comillas
        // Como escribimos con CsvUtils.escape, los campos no tendrán comas sin comillas.
        List<String> parts = splitCsv(line);
        String imdbId = unquote(parts.get(0));
        String title  = unquote(parts.get(1));
        String genresStr = unquote(parts.get(2));
        String emotion = unquote(parts.get(3));
        int year = Integer.parseInt(unquote(parts.get(4)));

        List<String> genres = genresStr.isBlank()
                ? List.of()
                : Arrays.stream(genresStr.split("\\|")).map(String::trim).collect(Collectors.toList());

        return new Movie(imdbId, title, genres, emotion, year);
    }

    private List<String> splitCsv(String s) {
        List<String> out = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\"') {
                if (inQuotes && i + 1 < s.length() && s.charAt(i + 1) == '\"') {
                    cur.append('\"'); i++; // comilla escapada
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                out.add(cur.toString()); cur.setLength(0);
            } else {
                cur.append(c);
            }
        }
        out.add(cur.toString());
        return out;
    }

    private String unquote(String s) {
        if (s.startsWith("\"") && s.endsWith("\"")) {
            return s.substring(1, s.length() - 1).replace("\"\"", "\"");
        }
        return s;
    }
}
