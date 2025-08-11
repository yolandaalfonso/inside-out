package dev.yolanda.models;

public enum Emotion {
    ALEGRIA(1),
    TRISTEZA(2),
    IRA(3),
    ASCO(4),
    MIEDO(5),
    ANSIEDAD(6),
    ENVIDIA(7),
    VERGUENZA(8),
    ABURRIMIENTO(9),
    NOSTALGIA(10);

    private int numberEmotion;

    private Emotion (int numberEmotion) {
        this.numberEmotion = numberEmotion;
    }

    public int getnumberEmotion() {
        return numberEmotion;
    }


}
