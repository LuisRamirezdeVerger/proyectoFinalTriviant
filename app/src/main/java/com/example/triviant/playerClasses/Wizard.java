package com.example.triviant.playerClasses;

import com.example.triviant.GameBoard;
import com.example.triviant.GameUtils;
import com.example.triviant.Player;

public class Wizard extends Player {
    private int abilityUsesLeft; // Counter for reroll uses named like "mana"
    private final GameBoard gameBoard;

    public Wizard(String name, GameBoard gameBoard){
        super(name);
        this.abilityUsesLeft = 2; // Mage starts with 2 "mana"
        this.gameBoard = gameBoard;
    }

    @Override
    public void move() {
        int steps = GameUtils.diceRoll();
        System.out.println(getName() + " rolled a " + steps + "!");

        // Check if mage wants to reroll and if he still have mana available
        if (abilityUsesLeft > 0) {
            System.out.println(getName() + ", do you want to reroll? (y/n)");
            String decision = "y"; // Let's assume the player wants to reroll for now

            if (decision.equals("y")) {
                steps = GameUtils.diceRoll();  // Reroll
                System.out.println(getName() + " rerolled and got a " + steps + "!");
                abilityUsesLeft--;  // Decrease reroll uses
                System.out.println(getName() + " has " + abilityUsesLeft + " mana left.");
            }
        } else {
            System.out.println(getName() + " has no mana left!");
        }

        // Move the mage based on the final steps after possible reroll
        setPosition(getPosition() + steps);
        System.out.println(getName() + " moved " + steps + " steps!");

    }

    @Override
    public void useAbility(Player other) {
        System.out.println(getName() + " uses their magic ability!");
    }

    public int getRerollUsesLeft() {
        return abilityUsesLeft;
    }
}
