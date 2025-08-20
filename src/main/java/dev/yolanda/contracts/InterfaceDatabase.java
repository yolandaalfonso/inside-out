package dev.yolanda.contracts;

import java.util.List;

import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.models.Mood;

public interface InterfaceDatabase {

    public void store(Moment moment);
    List<Moment> getAll();
    public void deleteMoment(int id);
    List<Moment> filterByEmotion(Emotion emotion);
    List<Moment> filterByDate(int month, int year);
    List<Moment> filterByMood(Mood mood);
}
