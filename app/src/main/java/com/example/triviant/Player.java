package com.example.triviant;

public class Player {
    private String name;
    private int position = 0;
    private boolean skipTurn = false;
    private boolean hasFinished = false;

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

    //Movement method (CHECK STEPS ON GAMEUTILS!!!)
    public void move(int steps){
       // int steps = GameUtils.diceRoll();
        position += steps;
    }

    //Skip turn method
    public boolean isSkipTurn(){
        return skipTurn;
    }

    public void setSkipTurn(boolean skipTurn){
        this.skipTurn = skipTurn;
    }

    public boolean hasFinished(){
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished){
        this.hasFinished = hasFinished;
    }
    //We've to add skills to every character!!
    public void useAbility(Player other){
        //Method to be overwritten
    }
}