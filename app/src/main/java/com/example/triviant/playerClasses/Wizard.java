package com.example.triviant.playerClasses;

import com.example.triviant.GameBoard;
import com.example.triviant.GameUtils;
import com.example.triviant.Player;

public class Wizard extends Player {
    private int abilityUsesLeft; // Counter for reroll uses
    private final GameBoard gameBoard;

    public Wizard(String name, GameBoard gameBoard){
        super(name);
        this.abilityUsesLeft = 2; // Mage starts with 2 reroll uses
        this.gameBoard = gameBoard;
    }

    @Override
    public void move() {
        int steps = GameUtils.diceRoll();
        System.out.println(getName() + " rolled a " + steps + "!");

        // Check if mage wants to reroll and if they still have rerolls available
        if (abilityUsesLeft > 0) {
            // Prompt for reroll (you can replace this with user input in a real game)
            System.out.println(getName() + ", do you want to reroll? (y/n)");
            // This is just an example, implement your own decision-making logic
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

        // Check for any special tile interactions
        // You can add checks for specific tiles like death tiles, etc., as needed
    }

    @Override
    public void useAbility(Player other) {
        // Implement a unique ability for the Mage here if needed
        System.out.println(getName() + " uses their magic ability!");
    }

    public int getRerollUsesLeft() {
        return abilityUsesLeft;
    }
}
