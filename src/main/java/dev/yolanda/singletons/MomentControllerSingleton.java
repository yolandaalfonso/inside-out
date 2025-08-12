package dev.yolanda.singletons;

import dev.yolanda.controllers.MomentController;

public class MomentControllerSingleton {
    private static final MomentController INSTANCE = new MomentController();

    private MomentControllerSingleton() {}

    public static MomentController getInstance() {
        return INSTANCE;
    }
}
