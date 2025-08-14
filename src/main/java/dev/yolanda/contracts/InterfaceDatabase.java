package dev.yolanda.contracts;

import java.util.List;

import dev.yolanda.models.Moment;

public interface InterfaceDatabase {

    public void store(Moment moment);
    List<Moment> getAll();
    boolean deleteMoment(int id);
}
