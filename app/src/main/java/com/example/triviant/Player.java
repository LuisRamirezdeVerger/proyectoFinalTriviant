package com.example.triviant;

public class Player {
    private String name;
    private int position = 0;
    private boolean skipTurn = false;

    public Player (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void move(int steps){
        position =+ steps;
    }

    public boolean isSkipTurn(){
        return skipTurn;
    }

    public void setSkipTurn(boolean skipTurn){
        this.skipTurn = skipTurn;
    }
    //We've to add skills to every character!!
}