package com.example;

import java.util.Calendar;
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

    @Test
    void testGetAllResultsSortedByScoreAndDate() {
        Calendar calendar = Calendar.getInstance();

        Date[] dates = new Date[6];
        dates[0] = calendar.getTime();

        for (int i = 1; i < 5; i++) {
            calendar.add(Calendar.SECOND, 1);
            dates[i] = calendar.getTime();
        }

        board.createMatch("Turkey", "Brasil", dates[0]);
        board.createMatch("Bosnia", "Nigeria", dates[1]);
        board.createMatch("Argentina", "Brazil", dates[2]);
        board.createMatch("Germany", "Italy", dates[3]);
        board.createMatch("Spain", "England", dates[4]);

        board.updateResult(2, 2, 0);
        board.updateResult(2, 2, 1);
        board.updateResult(3, 3, 2);
        board.updateResult(4, 4, 3);
        board.updateResult(7, 5, 4);

        List<Match> matchlist = board.getAllResults();

        assertEquals(matchlist.get(0).getHomeTeam().getTeamName(), "Spain");
        assertEquals(matchlist.get(0).getAwayTeam().getTeamName(), "England");

        assertEquals(matchlist.get(1).getHomeTeam().getTeamName(), "Germany");
        assertEquals(matchlist.get(1).getAwayTeam().getTeamName(), "Italy");

        assertEquals(matchlist.get(2).getHomeTeam().getTeamName(), "Argentina");
        assertEquals(matchlist.get(2).getAwayTeam().getTeamName(), "Brazil");

        assertEquals(matchlist.get(3).getHomeTeam().getTeamName(), "Bosnia");
        assertEquals(matchlist.get(3).getAwayTeam().getTeamName(), "Nigeria");

        assertEquals(matchlist.get(4).getHomeTeam().getTeamName(), "Turkey");
        assertEquals(matchlist.get(4).getAwayTeam().getTeamName(), "Brasil");
    }

}
