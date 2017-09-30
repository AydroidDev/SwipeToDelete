package com.fratane.max.swiperecyclerview.model;

import java.util.Date;

/**
 * Created by Max_F on 09/09/2017.
 */

public class Player {
    private String name;
    private String position;
    private int overall;
    private Team team;
    private String playerImg;

    public Player(){

    }

    public Player(String name, String position, int overall, Team team, String playerImg) {
        this.name = name;
        this.position = position;
        this.overall = overall;
        this.team = team;
        this.playerImg = playerImg;
    }

    public String getPlayerImg() {
        return playerImg;
    }

    public void setPlayerImg(String playerImg) {
        this.playerImg = playerImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
