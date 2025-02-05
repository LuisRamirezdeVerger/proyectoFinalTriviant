package com.example.triviant.playerClasses;

import com.example.triviant.GameBoard;
import com.example.triviant.GameUtils;
import com.example.triviant.Player;

public class Athlete extends Player {
    private final GameBoard gameBoard;

    public Athlete(String name, GameBoard gameBoard){
        super(name);
        this.gameBoard = gameBoard;
    }

    @Override
    public void move() {
        // Athlete will always has +1 on dice
        int steps = GameUtils.diceRoll() + 1;  // +1 to dice
        if (steps > 7) steps = 7;  // Never more than 7, just in case

        System.out.println(getName() + " rolled a " + steps + "!");

        // Movement
        setPosition(getPosition() + steps);
        System.out.println(getName() + " moved " + steps + " steps!");

    }

    @Override
    public void useAbility(Player other) {
        System.out.println(getName() + " uses his athletic ability!");
    }
}
