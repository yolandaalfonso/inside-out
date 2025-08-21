package dev.yolanda.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import dev.yolanda.models.Moment;

public class MomentCSVService {
    public void export(List<Moment> moments, Path path) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("id,title,description,mood\n");
        for (Moment m : moments) {
            sb.append(m.getId()).append(",");
            sb.append(CsvUtils.escape(m.getMomentTitle())).append(",");
            sb.append(CsvUtils.escape(m.getDescription())).append(",");
            sb.append(m.getMood()).append("\n");
        }
        Files.createDirectories(path.getParent());
        Files.writeString(path, sb.toString());
    }
}
