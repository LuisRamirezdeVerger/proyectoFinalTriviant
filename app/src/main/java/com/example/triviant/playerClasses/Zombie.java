package com.example.triviant.playerClasses;

import com.example.triviant.DeathTile;
import com.example.triviant.GameBoard;
import com.example.triviant.GameUtils;
import com.example.triviant.Player;

public class Zombie extends Player {
    private int abilityUsesLeft; //Counter for abilities
    private final GameBoard gameBoard;

    public Zombie(String name, GameBoard gameBoard){
        super (name);
        this.abilityUsesLeft = 3;
        this.gameBoard = gameBoard;
    }

    @Override
    public void move() {
        int steps = GameUtils.diceRoll();
        int movement = steps - 1;  // Moves 1 tile less
        if (movement < 1) movement = 1;  // Never less than 1 tile movement

        setPosition(getPosition() + movement);
        System.out.println(getName() + " moved " + movement + " steps!");

        //Verifying if zombie steps on death tile
        int currentPosition = getPosition();
        if (gameBoard.getTile(currentPosition) instanceof DeathTile){
            System.out.println(getName() + " is immune to the death square!");
            //Zombie is inmune to death tile
        }
    }

    @Override
    public void useAbility(Player other) {
        if (abilityUsesLeft > 0 && getPosition() == other.getPosition()) {
            other.setSkipTurn(true);  // Makes other player lose turn
            abilityUsesLeft--;  // 1 use less
            System.out.println(getName() + " uses their ability: Infects " + other.getName() + " and they skip their next turn!");
        } else if (abilityUsesLeft == 0) {
            System.out.println(getName() + " has no ability uses left!");
        } else {
            System.out.println(getName() + " is not in the same position as " + other.getName() + " to use the ability.");
        }
    }

    public int getAbilityUsesLeft() {
        return abilityUsesLeft;
    }
}
