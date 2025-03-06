package com.example;

import java.util.Date;
import java.util.List;

import com.example.models.Match;

class BoardServiceImpl implements IMatchService {

    @Override
    public IMatchService createMatch(String homeTeam, String awayTeam, Date date) {
        throw new UnsupportedOperationException("Unimplemented method 'createMatch'");
    }

    @Override
    public IMatchService endMatch(int matcId) {
        throw new UnsupportedOperationException("Unimplemented method 'endMatch'");
    }

    @Override
    public IMatchService updateResult(int homeScore, int awayScore, int index) {
        throw new UnsupportedOperationException("Unimplemented method 'updateResult'");
    }

    @Override
    public List<Match> getAllResults() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllResults'");
    }

}
