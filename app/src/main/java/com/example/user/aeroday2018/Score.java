package com.example.user.aeroday2018;

/**
 * Created by user on 16/04/2018.
 */

public class Score {
    String details ;
    int somme;

    public Score(String details, int somme) {
        this.details = details;
        this.somme = somme;
    }

    public Score() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }
}
