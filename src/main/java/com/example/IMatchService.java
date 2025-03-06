package com.example;

import java.util.Date;
import java.util.List;

import com.example.models.Match;

public interface IMatchService {

    IMatchService createMatch(String homeTeam, String awayTeam, Date date);

    IMatchService endMatch(int matcId);

    IMatchService updateResult(int homeScore, int awayScore, int index);

    List<Match> getAllResults();
}
