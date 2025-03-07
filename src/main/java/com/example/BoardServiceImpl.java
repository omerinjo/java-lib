package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.models.Match;

class BoardServiceImpl implements IMatchService {
    private final List<Match> matchList = new ArrayList<>();

    @Override
    public IMatchService createMatch(String homeTeam, String awayTeam, Date date) {
        Match match = new Match(homeTeam, awayTeam, date);
        matchList.add(match);
        return this;
    }

    @Override
    public IMatchService endMatch(int matchId) {
        matchList.remove(matchId);
        return this;
    }

    @Override
    public IMatchService updateResult(int homeScore, int awayScore, int index) {
        Match match = matchList.get(index);
        match.setScore(homeScore, awayScore);
        return this;
    }

    @Override
    public List<Match> getAllResults() {
        return this.matchList;
    }

}
