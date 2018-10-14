package com.toe;

public class Player {

    public static final int FIRST_PLAYER = 1;
    public static final int SECOND_PLAYER = 2;
    private String name;
    private int playerType;

    public Player(String name,int playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public int getPlayerType() {
        return playerType;
    }
    public void printUserInput() {
        System.out.println(getName()+" Please enter your choice from 1-9.");
    }
}
