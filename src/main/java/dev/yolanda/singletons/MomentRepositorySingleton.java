package dev.yolanda.singletons;

import dev.yolanda.repositories.MomentRepository;

public class MomentRepositorySingleton {
    
    private static MomentRepository INSTANCE;

    private MomentRepositorySingleton() {}

    public static MomentRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MomentRepository();
        }
        return INSTANCE;
    }
}
