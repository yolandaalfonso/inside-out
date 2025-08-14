package dev.yolanda.repositories;

import java.util.List;

import dev.yolanda.contracts.InterfaceDatabase;
import dev.yolanda.db.DiaryDatabase;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;

public class MomentRepository {
    
    private InterfaceDatabase db;

    public MomentRepository() {
        this.db = new DiaryDatabase();
    }

    public void StoreMoment(Moment moment) {
        db.store(moment);
    }

    public List<Moment> GetAllMoments() {
        return db.getAll();
    }

    public void deleteMoment(int id) {
        db.deleteMoment(id);
    }

    public List<Moment> filterByEmotion(Emotion emotion) {
        return db.filterByEmotion(emotion);
    }
}
