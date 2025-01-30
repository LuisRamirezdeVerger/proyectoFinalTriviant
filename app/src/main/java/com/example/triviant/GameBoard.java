package com.example.triviant;
import android.os.Build;

import androidx.annotation.NonNull;

import com.google.firebase.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.charset.StandardCharsets;
import java.util.*;
import org.json.*;
import java.io.*;

public class GameBoard {
    private final DatabaseReference databaseReference;
    private final List<Questions> questionsCache = new ArrayList<>();

    List<Tile> tiles = new ArrayList<>();

    public GameBoard(String board_config){
        databaseReference = FirebaseDatabase.getInstance().getReference("questions");
        fetchQuestionsFromFireBase();
        initializeBoard(board_config);
    }

    private void initializeBoard(String board_config) {
        //Usaremos un JSON
        try {
            // Leer el archivo JSON
            InputStream is = Objects.requireNonNull(getClass().getClassLoader()).getResourceAsStream(board_config);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();

            String jsonText = new String(buffer, StandardCharsets.UTF_8);
            //I've to add next line 'cause IDE ask me to do it
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                jsonText = new String (is.readAllBytes());
            }

            JSONArray tilesArray = new JSONArray(jsonText);
            int questionIndex = 0;

            for (int i = 0; i < tilesArray.length(); i++){
                JSONObject tileObject  = tilesArray.getJSONObject(i);
                int position = tileObject .getInt("position");
                String type = tileObject .getString("type");

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
                        if (questionIndex < questionsCache.size()) {
                            tiles.add(new QuestionTile(position, questionsCache.get(questionIndex++)));
                        } else {
                            throw new IllegalStateException("No hay suficientes preguntas para las casillas.");
                        }
                        break;
                    case "move":
                        tiles.add(new Movetile(position, tileObject .getInt("steps")));
                        break;
                    case "loseTurn":
                        tiles.add(new LoseTurnTile(position));
                        break;
                    case "warp":
                        tiles.add(new WarpTile(position, tileObject .getInt("targetPosition")));
                        break;
                    default:
                        throw new IllegalArgumentException("Tile type unknown" + type);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing board" + e);
        }
    }

    public int getNumberOfTiles() {
        return tiles.size();
    }

    public Tile getTile(int position) {
        return tiles.get(position - 1);
    }

    //Example for fetching questions
    private List<String> fetchQuestionsFromDB() {
        return Arrays.asList(
                "¿Cuál es el planeta más cercano al Sol?",
                "¿Cuánto es 5 x 7?",
                "¿Quién escribió 'Don Quijote'?"
        );
    }

    private void fetchQuestionsFromFireBase(){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot questionSnapshot : dataSnapshot.getChildren()){
                    Questions question = questionSnapshot.getValue(Questions.class);
                    if (question != null){
                        questionsCache.add(question);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("Error loading questions: " + databaseError.getMessage());
            }
        });
    }

    public List<Questions> getQuestionsCache() {
        return this.questionsCache;
    }
}
