package com.doggs.model;

import java.util.List;

public class Team {
    private String name;
    private Integer rank;
    private Record record;
    private Statistic seasonalStats;
    private List<Matchup> previousMatchups;

    public Team(String name, Integer rank, Record record, Statistic seasonalStats, List<Matchup> previousMatchups) {
        this.name = name;
        this.rank = rank;
        this.record = record;
        this.seasonalStats = seasonalStats;
        this.previousMatchups = previousMatchups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Statistic getSeasonalStats() {
        return seasonalStats;
    }

    public void setSeasonalStats(Statistic seasonalStats) {
        this.seasonalStats = seasonalStats;
    }

    public List<Matchup> getPreviousMatchups() {
        return previousMatchups;
    }

    public void setPreviousMatchups(List<Matchup> previousMatchups) {
        this.previousMatchups = previousMatchups;
    }
}
