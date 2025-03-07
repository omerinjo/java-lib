package com.example;

public class MatchServiceFactory {
    public static IMatchService newInstance() {
        return new BoardServiceImpl();
    }
}
