package dev.yolanda.models;

import java.util.Date;

public class Moment {
    
    private int id;
    private String momentTitle;
    private String description;
    private Emotion emotion;
    private Date date;
    private Date creationDate;
    private Date modificationDate;
    
    public Moment(int id, String momentTitle, String description, Emotion emotion, Date date) {
        this.id = id;
        this.momentTitle = momentTitle;
        this.description = description;
        this.emotion = emotion;
        this.date = date;
    }

    

}
