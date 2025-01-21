package com.example.triviant;

import org.json.*;
import java.util.*;

public class RavenBrained {
    public static void main (String[] args){
        String jsonFileName = "board_config.json";
        GameBoard board = new GameBoard("board_config.json");

        List<Player> players = Arrays.asList(new Player("Player 1"), new Player("Player 2"));
        boolean gameFinished = false;

        while(!gameFinished){
            for (Player player : players){
                if (player.hasFinished())
                    continue;

                if (player.isSkipTurn()){
                    System.out.println(player.getName() + "lose turn");
                    player.setSkipTurn(false);
                    continue;
                }

                int diceRoll = new Random().nextInt(6) + 1;
                System.out.println(player.getName() + "tira el dado: " + diceRoll);
            }
        }


    }
}
