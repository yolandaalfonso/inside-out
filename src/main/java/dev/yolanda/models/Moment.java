package dev.yolanda.models;

import java.util.Date;

public class Moment {

    private static int nextId=1;
    
    private int id;
    private String momentTitle;
    private String description;
    private Emotion emotion;
    private Date date;
    private Date creationDate;
    private Date modificationDate;

    public Moment(int id, String momentTitle, String description, Emotion emotion, Date date) {
        this.id = nextId++;
        this.momentTitle = momentTitle;
        this.description = description;
        this.emotion = emotion;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    

    

}
