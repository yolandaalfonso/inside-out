package dev.yolanda.contracts;

import java.util.List;

import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;

public interface InterfaceDatabase {

    public void store(Moment moment);
    List<Moment> getAll();
    public void deleteMoment(int id);
    List<Moment> filterByEmotion(Emotion emotion);
}
