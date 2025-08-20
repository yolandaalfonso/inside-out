package dev.yolanda.models;

public enum Mood {
    BUENO(1),
    MALO(2);
    

    private final int numberMood; //para los test

    Mood (int numberMood) {
        this.numberMood = numberMood;
    }

    public int getNumberMood() {
        return numberMood;
    }
}
