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
    
}
