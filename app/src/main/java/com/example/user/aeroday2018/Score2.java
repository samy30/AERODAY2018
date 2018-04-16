package com.example.user.aeroday2018;

/**
 * Created by user on 16/04/2018.
 */

public class Score2 {
    String details ;
    int sum;
    int nbreCollision;
    int dure;

    public Score2(String details, int sum, int nbreCollision, int dure) {
        this.details = details;
        this.sum = sum;
        this.nbreCollision = nbreCollision;
        this.dure = dure;
    }

    public Score2() {
    }

    public String getDetails() {
        return details;
    }

    public int getSum() {
        return sum;
    }

    public int getNbreCollision() {
        return nbreCollision;
    }

    public int getDure() {
        return dure;
    }
}
