package com.example.triviant;
import java.util.*;

public class GameBoard {

    private List<Tile> tiles = new ArrayList<>();

    public GameBoard(){
        initializeBoard();
    }

    private void initializeBoard() {
        //Usaremos un JSON
    }

    public Tile getTile(int position) {
        return tiles.get(position - 1);
    }

    private List<String> fetchQuestionsFromDB() {
        return Arrays.asList(
                "¿Cuál es el planeta más cercano al Sol?",
                "¿Cuánto es 5 x 7?",
                "¿Quién escribió 'Don Quijote'?"
        );
    }
}
