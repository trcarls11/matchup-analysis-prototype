package com.doggs.model;

public class Record {
    private int wins;
    private int losses;

    public Record() {
        this.wins = 0;
        this.losses = 0;
    }

    public Record(int wins, int losses) {
        this.wins = wins;
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
