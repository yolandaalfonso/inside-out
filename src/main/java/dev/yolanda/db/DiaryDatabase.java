package dev.yolanda.db;

import java.util.ArrayList;
import java.util.List;

import dev.yolanda.contracts.InterfaceDatabase;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.models.Mood;

public class DiaryDatabase implements InterfaceDatabase{

    private List<Moment> moments;

    public DiaryDatabase() {
        this.moments = new ArrayList<>();
    }

    @Override
    public void store(Moment moment){
        moments.add(moment);
    }

    @Override
    public List<Moment> getAll() {
        return moments;
    }

    @Override
    public void deleteMoment(int id){
        for (int i = 0; i < moments.size(); i++) {
            if (moments.get(i).getId() == id) { // Compara con el id del Moment
                moments.remove(i);
            }
        }
    }

    @Override
    public List<Moment> filterByEmotion(Emotion emotion) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment m : moments) {
            if (m.getEmotion() == emotion) {
                filtered.add(m);
            }
        }
        return filtered;
    }

    @Override
    public List<Moment> filterByDate(int month, int year) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment m : moments) {
            if (m.getDate().getMonthValue() == month && m.getDate().getYear() == year) {
                filtered.add(m);
            }
        }
        return filtered;
    }

    @Override
    public List<Moment> filterByMood(Mood mood) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment m : moments) {
            if (m.getMood() == mood) {
                filtered.add(m);
            }
        }
        return filtered;
    }
    
}
