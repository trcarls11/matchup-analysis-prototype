package com.doggs.model;

public class Statistic {
    private double ppg;
    private double dPpg;

    public Statistic() {
        this.ppg = 0.0;
        this.dPpg = 0.0;
    }

    public Statistic(double ppg, double dPpg) {
        this.ppg = ppg;
        this.dPpg = dPpg;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public double getdPpg() {
        return dPpg;
    }

    public void setdPpg(double dPpg) {
        this.dPpg = dPpg;
    }
}
