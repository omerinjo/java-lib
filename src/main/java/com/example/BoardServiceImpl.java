package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.models.Match;
import com.example.validation.MatchValidation;

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
        try {
            MatchValidation.validateMatchIdExist(matchId, matchList);
            matchList.remove(matchId);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

        return this;
    }

    @Override
    public IMatchService updateResult(int homeScore, int awayScore, int matchId) {
        try {
            MatchValidation.validateMatchIdExist(matchId, matchList);
            Match match = matchList.get(matchId);
            match.setScore(homeScore, awayScore);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

        return this;
    }

    @Override
    public List<Match> getAllResults() {
        return this.matchList.stream()
                .sorted(Comparator.comparingInt((Match match) -> match.getResult().getHomeScore()
                        + match.getResult().getAwayScore()).reversed()
                        .thenComparing(Match::getDate, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

}
