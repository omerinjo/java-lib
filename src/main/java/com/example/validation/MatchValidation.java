package com.example.validation;

import java.util.List;

import com.example.exception.MatchException;
import com.example.models.Match;

public class MatchValidation {

    public static void validateMatchIdExist(int matchId, List<Match> matchList) throws MatchException {
        if (matchId < 0 || matchId >= matchList.size()) {
            throw new MatchException(
                    String.format("Error: Match with matchId %d does not exist. No update performed.", matchId));
        }
    }
}
