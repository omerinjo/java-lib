package com.example;

import org.junit.jupiter.api.BeforeEach;

public class MatchServiceTest {
    private BoardServiceImpl board;

    @BeforeEach
    void setUp() {
        board = new BoardServiceImpl();
    }

}
