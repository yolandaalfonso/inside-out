package dev.yolanda.db;

import java.util.ArrayList;
import java.util.List;

import dev.yolanda.contracts.InterfaceDatabase;
import dev.yolanda.models.Moment;

public class DiaryDatabase implements InterfaceDatabase{

    private List<Moment> moments;

    public DiaryDatabase() {
        this.moments = new ArrayList<>();
    }

    @Override
    public void store(Moment moment){
        moments.add(moment);
    }
    
}
