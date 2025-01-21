package com.example.triviant;
import android.os.Build;

import java.util.*;
import org.json.*;
import java.io.*;

public class GameBoard {

    private List<Tile> tiles = new ArrayList<>();

    public GameBoard(String board_config){
        initializeBoard(board_config);
    }

    private void initializeBoard(String board_config) {
        //Usaremos un JSON
        try(InputStream is = getClass().getClassLoader().getResourceAsStream("assets/" + board_config)){
            if (is == null) throw new FileNotFoundException("JSON file not found.");

            String jsonText = null;
            //I've to add next line 'cause IDE ask me to do it
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                jsonText = new String (is.readAllBytes());
            }
            JSONArray jsonArray = new JSONArray(jsonText);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int position = jsonObject.getInt("position");
                String type = jsonObject.getString("type");

                switch (type){
                    case "start":
                        tiles.add(new StartTile());
                        break;
                    case "end":
                        tiles.add(new EndTile(position));
                        break;
                    case "normal":
                        tiles.add(new normalTile(position));
                        break;
                    case "question":
                        tiles.add(new QuestionTile(position, fetchQuestionsFromDB()));
                        break;
                    case "move":
                        tiles.add(new Movetile(position, jsonObject.getInt("steps")));
                        break;
                    case "loseTurn":
                        tiles.add(new LoseTurnTile(position));
                        break;
                    case "warp":
                        tiles.add(new WarpTile(position, jsonObject.getInt("targetPosition")));
                        break;
                    default:
                        throw new IllegalArgumentException("Tile type unknown" + type);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error initializing board" + e);
        }
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
