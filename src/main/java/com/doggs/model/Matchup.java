package com.doggs.model;

import java.util.Date;

public class Matchup {
//    private Date date;
    private Team opponent;
    private int pointsAllowed;
    private int pointsScored;
    private String result;

    public Matchup(Team opponent, int pointsAllowed, int pointsScored, String result) {
        this.opponent = opponent;
        this.pointsAllowed = pointsAllowed;
        this.pointsScored = pointsScored;
        this.result = result;
    }

    public Team getOpponent() {
        return opponent;
    }

    public void setOpponent(Team opponent) {
        this.opponent = opponent;
    }

    public int getPointsAllowed() {
        return pointsAllowed;
    }

    public void setPointsAllowed(int pointsAllowed) {
        this.pointsAllowed = pointsAllowed;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
