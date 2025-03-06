package com.example.models;

import java.util.Date;

public class Match {
    private final Team homeTeam;
    private final Team awayTeam;
    private Result result;
    private Date startDate;

    public Match(String homeTeam, String awayTeam, Date date) {
        this.homeTeam = new Team(homeTeam);
        this.awayTeam = new Team(awayTeam);
        this.startDate = date;
    }

    public void setScore(int homeScore, int awayScore) {
        this.result = new Result(homeScore, awayScore);
    }

    @Override
    public String toString() {
        return String.format("%s:%d-%d:%s", this.homeTeam, this.result.getHomeScore(), this.result.getAwayScore(),
                this.awayTeam);
    }
}
