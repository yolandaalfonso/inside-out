package dev.yolanda.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moment {

    private static int nextId=1;
    
    private int id;
    private String momentTitle;
    private String description;
    private Emotion emotion;
    private LocalDate date;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public Moment(int id, String momentTitle, String description, Emotion emotion, LocalDate date) {
        this.id = nextId++;
        this.momentTitle = momentTitle;
        this.description = description;
        this.emotion = emotion;
        this.date = date;

        this.creationDate = LocalDateTime.now();
        this.modificationDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMomentTitle() {
        return momentTitle;
    }

    public void setMomentTitle(String momentTitle) {
        this.momentTitle = momentTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    

    

}
