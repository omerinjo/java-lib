package com.example;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.models.Match;

public class MatchServiceTest {
    private BoardServiceImpl board;

    @BeforeEach
    void setUp() {
        board = new BoardServiceImpl();
    }

    @Test
    void testCreateMatchWillAddNewMatchInMatchList() {
        board.createMatch("Argentina", "Brazil", new Date());
        board.createMatch("Germany", "England", new Date());
        board.createMatch("Croatia", "Italy", new Date());
        board.createMatch("Bosnia", "Nigeria", new Date());

        List<Match> matchList = board.getAllResults();

        assertEquals(matchList.get(0).getHomeTeam().getTeamName(), "Argentina");
        assertEquals(matchList.get(0).getAwayTeam().getTeamName(), "Brazil");
        assertEquals(matchList.get(0).getResult().getHomeScore(), 0);
        assertEquals(matchList.get(0).getResult().getAwayScore(), 0);

        assertEquals(matchList.get(1).getHomeTeam().getTeamName(), "Germany");
        assertEquals(matchList.get(1).getAwayTeam().getTeamName(), "England");
        assertEquals(matchList.get(1).getResult().getHomeScore(), 0);
        assertEquals(matchList.get(1).getResult().getAwayScore(), 0);

        assertEquals(matchList.get(2).getHomeTeam().getTeamName(), "Croatia");
        assertEquals(matchList.get(2).getAwayTeam().getTeamName(), "Italy");
        assertEquals(matchList.get(2).getResult().getHomeScore(), 0);
        assertEquals(matchList.get(2).getResult().getAwayScore(), 0);

        assertEquals(matchList.get(3).getHomeTeam().getTeamName(), "Bosnia");
        assertEquals(matchList.get(3).getAwayTeam().getTeamName(), "Nigeria");
        assertEquals(matchList.get(3).getResult().getHomeScore(), 0);
        assertEquals(matchList.get(3).getResult().getAwayScore(), 0);

        assertEquals(matchList, matchList);
        assertEquals(matchList.size(), 4);

    }

    @Test
    void testEndMatchWillRemoveMatchFromMatchList() {
        board.createMatch("Argentina", "Brazil", new Date());
        board.createMatch("Germany", "England", new Date());

        List<Match> matchList = board.getAllResults();
        board.endMatch(0);

        assertEquals(matchList.size(), 1);

        assertEquals(matchList.get(0).getHomeTeam().getTeamName(), "Germany");
        assertEquals(matchList.get(0).getAwayTeam().getTeamName(), "England");
        assertEquals(matchList.get(0).getResult().getHomeScore(), 0);
        assertEquals(matchList.get(0).getResult().getAwayScore(), 0);

    }

    @Test
    void testUpdateResultWillUpdateResultForMatch() {
        board.createMatch("Argentina", "Brazil", new Date());

        board.updateResult(1, 3, 0);
        List<Match> matchList = board.getAllResults();

        assertEquals(matchList.get(0).getResult().getHomeScore(), 1);
        assertEquals(matchList.get(0).getResult().getAwayScore(), 3);

    }

}
