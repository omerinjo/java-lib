package com.example.models;

public class Team {
    private final String name;

    public Team(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
