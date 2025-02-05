package com.example.triviant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Board extends AppCompatActivity {

    ImageView card;
    Button buttonCard;
    ImageView backQuest = findViewById(R.id.backQuest);
    ImageView woodQuest = findViewById(R.id.woodQuest);
    ImageView option1 = findViewById(R.id.option1);
    ImageView option2 = findViewById(R.id.option2);
    ImageView option3 = findViewById(R.id.option3);
    ImageView option4 = findViewById(R.id.option4);
    ImageView logoQuest = findViewById(R.id.logoQuest);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_board);

        card = findViewById(R.id.card);
        buttonCard = findViewById(R.id.buttonCard);

        buttonCard.setOnClickListener(v -> {
            Random random = new Random();
            int movement = random.nextInt(6)+1;


            System.out.println(movement);

            switch (movement)
            {
                case(1):
                    card.setImageResource(R.drawable.one);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(2):
                    card.setImageResource(R.drawable.two);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(3):
                    card.setImageResource(R.drawable.three);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(4):
                    card.setImageResource(R.drawable.four);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(5):
                    card.setImageResource(R.drawable.five);
                    System.out.println(movement);
                    card.invalidate();
                    break;
                case(6):
                    card.setImageResource(R.drawable.six);
                    System.out.println(movement);
                    card.invalidate();
                    break;
            }

            /*ubi actual=ubi actual + movement
            jugadoreste.setUbi(ubi actual)
            openQuestion(String personaje)
            */

        });
    }

    void openQuestion(String personaje) {
       backQuest.setVisibility(View.VISIBLE);
       woodQuest.setVisibility(View.VISIBLE);
       option1.setVisibility(View.VISIBLE);
       option2.setVisibility(View.VISIBLE);
       option3.setVisibility(View.VISIBLE);
       option4.setVisibility(View.VISIBLE);
       logoQuest.setVisibility(View.VISIBLE);
       //backQuest.setVisibility(View.VISIBLE);

    }
}


