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

    Emotion (int numberEmotion) {
        this.numberEmotion = numberEmotion;
    }

    public int getNumberEmotion() {
        return numberEmotion;
    }

    /*public static Emotion getEmotionByNumber(int number) {
        for (Emotion emotion : values()) {
            if (emotion.getNumberEmotion() == number) {
                return emotion;
            }
        }
        return null;
    }*/


}
