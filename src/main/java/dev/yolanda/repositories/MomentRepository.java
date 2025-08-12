package dev.yolanda.repositories;

import dev.yolanda.db.DiaryDatabase;

public class MomentRepository {
    
    private InterfaceDatabase db;

    public MomentRepository() {
        this.db = new DiaryDatabase();
    }

    public void StoreMoment(Moment moment) {
        db.store(moment);
    }
}
